package com.app.quantitymeasurement.security;

import com.app.quantitymeasurement.dto.AuthResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public OAuth2AuthenticationSuccessHandler(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        // ── Safely extract user attributes ────────────────────────
        Object principal = authentication.getPrincipal();

        String email   = null;
        String name    = null;
        String picture = null;

        if (principal instanceof CustomOAuth2User customUser) {
            // Our custom wrapper
            email   = customUser.getEmail();
            name    = customUser.getFullName();
            picture = customUser.getPicture();

        } else if (principal instanceof OAuth2User oAuth2User) {
            // Fallback — direct OAuth2User
            Map<String, Object> attributes = oAuth2User.getAttributes();
            email   = (String) attributes.get("email");
            name    = (String) attributes.get("name");
            picture = (String) attributes.get("picture");
        }

        // ── Safety check ──────────────────────────────────────────
        if (email == null) {
            response.setStatus(500);
            response.setContentType("application/json");
            response.getWriter().write(
                "{\"error\":\"Could not extract email from Google profile\"}"
            );
            return;
        }

        // ── Create JWT ────────────────────────────────────────────
        String token = jwtTokenProvider.createToken(email, name, picture);

        // ── Build response ────────────────────────────────────────
        AuthResponseDTO authResponse = new AuthResponseDTO(
                token,
                email,
                name,
                picture,
                jwtTokenProvider.getExpirationMs()
        );

        // ── Write JSON response ───────────────────────────────────
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(authResponse));
    }
}