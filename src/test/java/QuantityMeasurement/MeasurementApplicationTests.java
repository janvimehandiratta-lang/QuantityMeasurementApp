package QuantityMeasurement;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class MeasurementApplicationTests {
	@Test
    void testFeetEquality_SameValue() {

        MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(89.6);

        MeasurementApplication.Feet f2 = new MeasurementApplication.Feet(89.6);
        assertEquals(f1, f2);

    }
    @Test
    void testFeetEquality_DifferentValue() {
    	MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(89.6);
    	MeasurementApplication.Feet f2 = new MeasurementApplication.Feet(34.6);
        assertNotEquals(f1, f2);

    }
    @Test

    void testFeetEquality_NullValue() {
    	MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(5.0);
        assertNotEquals(f1, null);

    }

    @Test
    void testFeetEquality_DifferentType() {
    	MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(5.0);
        String other = "5.0";
        assertNotEquals(f1, other);

    }
}