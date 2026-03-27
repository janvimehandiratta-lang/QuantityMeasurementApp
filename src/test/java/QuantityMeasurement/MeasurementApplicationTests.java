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
    
    
    
    
    @Test
    void testInchEquality_SameValue() {

        MeasurementApplication.Inch I1 = new MeasurementApplication.Inch(89.6);

        MeasurementApplication.Inch I2 = new MeasurementApplication.Inch(89.6);
        assertEquals(I1, I2);

    }
    @Test
    void testInchEquality_DifferentValue() {
    	MeasurementApplication.Inch I1 = new MeasurementApplication.Inch(89.6);
    	MeasurementApplication.Inch I2 = new MeasurementApplication.Inch(34.6);
        assertNotEquals(I1, I2);

    }
    @Test

    void testInchEquality_NullValue() {
    	MeasurementApplication.Inch I1 = new MeasurementApplication.Inch(5.0);
        assertNotEquals(I1, null);

    }

    @Test
    void testInchEquality_DifferentType() {
    	MeasurementApplication.Inch I1 = new MeasurementApplication.Inch(5.0);
        String other = "5.0";
        assertNotEquals(I1, other);

    }
}