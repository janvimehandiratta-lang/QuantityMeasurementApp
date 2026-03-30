package QuantityMeasurement;
import com.quantity.measurement.enums.*;
import static org.junit.jupiter.api.Assertions.*;

import com.quantity.measurement.model.QuantityLength;
import org.junit.jupiter.api.Test;
class MeasurementApplicationTests {
	@Test

    void testEquality_FeetToFeet_SameValue() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.Feet);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.Feet);
        assertEquals(q1, q2);

    }
	
    @Test

    void testEquality_InchToInch_SameValue() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.Inch);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.Inch);
        assertEquals(q1, q2);

    }

    @Test

    void testEquality_FeetToInch_EquivalentValue() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.Feet);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.Inch);
        assertEquals(q1, q2);

    }
    @Test

    void testEquality_InchToFeet_EquivalentValue() {
    	
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.Inch);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.Feet);
        assertEquals(q1, q2);

    }

    @Test

    void testEquality_FeetToFeet_DifferentValue() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.Feet);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.Feet);
        assertNotEquals(q1, q2);

    }

    @Test

    void testEquality_InchToInch_DifferentValue() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.Inch);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.Inch);
        assertNotEquals(q1, q2);

    }

    @Test

    void testEquality_InvalidUnit() {

        assertThrows(IllegalArgumentException.class, () -> {

            new QuantityLength(5.0, null);
        });
    }
    @Test

    void testEquality_SameReference() {

        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.Feet);
        assertEquals(q1, q1);

    }
    
    @Test

    void testEquality_NullComparison() {

        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.Feet);
        assertNotEquals(q1, null);

    }

    @Test

    void testEquality_NonNumericInput() {

        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.Feet);
        assertNotEquals(q1, "5.0");

    }
}