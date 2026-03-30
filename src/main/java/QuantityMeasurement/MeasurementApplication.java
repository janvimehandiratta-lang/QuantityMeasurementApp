package QuantityMeasurement;

import com.quantity.measurement.enums.LengthUnit;
import com.quantity.measurement.model.QuantityLength;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class MeasurementApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first value: ");
            double value1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter first unit (Feet, Inch): ");
            String unit1 = scanner.nextLine();

            System.out.print("Enter second value: ");
            double value2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second unit (Feet, Inch): ");
            String unit2 = scanner.nextLine();

            // ✅ FIX: Proper format conversion
            LengthUnit u1 = LengthUnit.valueOf(
                unit1.substring(0,1).toUpperCase() + unit1.substring(1).toLowerCase()
            );

            LengthUnit u2 = LengthUnit.valueOf(
                unit2.substring(0,1).toUpperCase() + unit2.substring(1).toLowerCase()
            );

            QuantityLength length1 = new QuantityLength(value1, u1);
            QuantityLength length2 = new QuantityLength(value2, u2);

            if (length1.equals(length2)) {
                System.out.println("The two lengths are equal.");
            } else {
                System.out.println("The two lengths are NOT equal.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid unit entered!");
        }
    }
}