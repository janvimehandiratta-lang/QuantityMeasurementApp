package QuantityMeasurement;
import com.quantity.measurement.enums.*;
import com.quantity.measurement.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.quantity.measurement.model.QuantityLength;



class MeasurementApplicationTests {
	
	private static final double EPSILON = 1e-6;
	 private static final double DELTA = 1e-3;
	
	//1
	@Test

    void testEquality_YardToYard_SameValue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(1.0, LengthUnit.YARD)));

    }

	//2
    @Test

    void testEquality_YardToYard_DifferentValue() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(2.0, LengthUnit.YARD)));

    }
    //3
    @Test

    void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(3.0, LengthUnit.FEET)));

    }
    //4
    @Test

    void testEquality_FeetToYard_EquivalentValue() {
        assertTrue(new QuantityLength(3.0, LengthUnit.FEET)
                .equals(new QuantityLength(1.0, LengthUnit.YARD)));

    }
    //5
    @Test

    void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(36.0, LengthUnit.INCH)));

    }
    //6
    @Test

    void testEquality_InchesToYard_EquivalentValue() {
        assertTrue(new QuantityLength(36.0, LengthUnit.INCH)
                .equals(new QuantityLength(1.0, LengthUnit.YARD)));

    }
    //7
    @Test

    void testEquality_YardToFeet_NonEquivalentValue() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(2.0, LengthUnit.FEET)));

    }
    //8
    @Test

    void testEquality_centimetersToInches_EquivalentValue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.CM)
                .equals(new QuantityLength(0.3937008, LengthUnit.INCH)));

    }
    //9
    @Test

    void testEquality_centimetersToFeet_NonEquivalentValue() {
        assertFalse(new QuantityLength(1.0, LengthUnit.CM)
                .equals(new QuantityLength(1.0, LengthUnit.FEET)));

    }
    //10
    @Test

    void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);
        assertTrue(yard.equals(feet) && feet.equals(inch) && yard.equals(inch));

    }
    //11
    @Test

    void testEquality_YardWithNullUnit() {
        assertThrows(Exception.class, () -> {
            new QuantityLength(1.0, null);

        });
      }

    //12
    @Test

    void testEquality_YardSameReference() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.YARD);
        assertTrue(q.equals(q));
    }
    //13
    @Test

    void testEquality_YardNullComparison() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARD).equals(null));

    }
    //14
    @Test

    void testEquality_CentimetersWithNullUnit() {
        assertThrows(Exception.class, () -> {
            new QuantityLength(1.0, null);

        });

    }
    //15
    @Test

    void testEquality_CentimetersSameReference() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.CM);
        assertTrue(q.equals(q));

    }
    //16
    @Test

    void testEquality_CentimetersNullComparison() {
        assertFalse(new QuantityLength(1.0, LengthUnit.CM).equals(null));
    }
    //17
    @Test

    void testEquality_AllUnits_ComplexScenario() {
        assertTrue(new QuantityLength(2.0, LengthUnit.YARD)
                .equals(new QuantityLength(6.0, LengthUnit.FEET)));
        assertTrue(new QuantityLength(6.0, LengthUnit.FEET)
                .equals(new QuantityLength(72.0, LengthUnit.INCH)));

    }
    //18
    @Test

    void testConversion_FeetToInches() {
        assertEquals(12.0,
                QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH),
                0.0001);

    }
    //19
    @Test

    void testConversion_InchesToFeet() {
        assertEquals(2.0,
                QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET),
                0.0001);

    }
    //20
    @Test

    void testConversion_YardsToInches() {
        assertEquals(36.0,
                QuantityLength.convert(1.0, LengthUnit.YARD, LengthUnit.INCH),
                0.0001);

    }
    //21
    @Test

    void testConversion_InchesToYards() {
        assertEquals(2.0,
                QuantityLength.convert(72.0, LengthUnit.INCH, LengthUnit.YARD),
                0.0001);

    }
    //22
    @Test

    void testConversion_CentimetersToInches() {
        assertEquals(1.0,
                QuantityLength.convert(2.54, LengthUnit.CM, LengthUnit.INCH),
                0.0001);

    }
    //23
    @Test

    void testConversion_FeetToYard() {
        assertEquals(2.0,
                QuantityLength.convert(6.0, LengthUnit.FEET, LengthUnit.YARD),
                0.0001);

    }
    //24
    @Test

    void testConversion_ZeroValue() {
        assertEquals(0.0,
                QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH),
                0.0001);

    }
    //25
    @Test

    void testConversion_NegativeValue() {
        assertEquals(-12.0,
                QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH),
                0.0001);

    }
    //26
    @Test

    void testConversion_RoundTrip() {
        double value = 5.0;
        double converted = QuantityLength.convert(value, LengthUnit.FEET, LengthUnit.INCH);
        double back = QuantityLength.convert(converted, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(value, back, 0.0001);

    }
    //27
    @Test

    void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(1.0, null, LengthUnit.FEET);

        });

    }
    //28
    @Test

    void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH);

        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCH);

        });

    }
    //29
    @Test

    void testConversion_PrecisionTolerance() {
        double result = QuantityLength.convert(1.0, LengthUnit.CM, LengthUnit.INCH);
        assertEquals(0.393701, result, 0.0001);

    }
    //30
    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET)
                .add(new QuantityLength(2.0, LengthUnit.FEET));
        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
    }
    //31
    @Test
    void testAddition_SameUnit_InchPlusInch() {
        QuantityLength result = new QuantityLength(5.0, LengthUnit.INCH)
                .add(new QuantityLength(7.0, LengthUnit.INCH));
        assertEquals(new QuantityLength(12.0, LengthUnit.INCH), result);
    }
    //32
    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET)
                .add(new QuantityLength(12.0, LengthUnit.INCH));
        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }
    //33
    @Test
   void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength result = new QuantityLength(12.0, LengthUnit.INCH)
                .add(new QuantityLength(1.0, LengthUnit.FEET));
        assertEquals(new QuantityLength(24.0, LengthUnit.INCH), result);
    }
    //34
    @Test
    void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength result = new QuantityLength(1.0, LengthUnit.YARD)
                .add(new QuantityLength(3.0, LengthUnit.FEET));
        assertEquals(new QuantityLength(2.0, LengthUnit.YARD), result);
    }
    //35
    @Test

    void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength result = new QuantityLength(2.54, LengthUnit.CM)
                .add(new QuantityLength(1.0, LengthUnit.INCH));
        assertEquals(5.08, result.toConvert(LengthUnit.CM), 0.01);

    }
    //36
    @Test
    void testAddition_Commutativity() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);
        double result1 = a.add(b).toFeet();
        double result2 = b.add(a).toFeet();
        assertEquals(result1, result2, EPSILON);
    }
    //37
    @Test
    void testAddition_WithZero() {
        QuantityLength result = new QuantityLength(5.0, LengthUnit.FEET)
                .add(new QuantityLength(0.0, LengthUnit.INCH));
        assertEquals(new QuantityLength(5.0, LengthUnit.FEET), result);
    }
    //38
    @Test
    void testAddition_NegativeValues() {
        QuantityLength result = new QuantityLength(5.0, LengthUnit.FEET)
                .add(new QuantityLength(-2.0, LengthUnit.FEET));
        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
   }
    //39
    @Test
    void testAddition_NullSecondOperand() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            q.add(null);
        });
    }
    //40
    @Test
    void testAddition_LargeValues() {
       QuantityLength result = new QuantityLength(1e6, LengthUnit.FEET)
                .add(new QuantityLength(1e6, LengthUnit.FEET));
       assertEquals(new QuantityLength(2e6, LengthUnit.FEET), result);
    }
    //41
    @Test
    void testAddition_SmallValues() {
        QuantityLength result = new QuantityLength(0.001, LengthUnit.FEET)
               .add(new QuantityLength(0.002, LengthUnit.FEET));
        		assertEquals(new QuantityLength(0.003, LengthUnit.FEET), result);
    }
    
    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        // Explicit target = FEET: 1ft + 1ft = 2.0 FEET
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.FEET);
        
        assertEquals(2.0, result.toConvert(LengthUnit.FEET), DELTA);
        assertTrue(result.toString().contains("FEET"));
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        // Explicit target = INCHES: 1ft + 1ft = 24.0 INCHES
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.INCH);
        
        assertEquals(24.0, result.toConvert(LengthUnit.INCH), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        // Target unit different from both operands: 1ft + 1ft = ~0.667 YARDS
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.YARD);
        
        assertEquals(0.667, result.toConvert(LengthUnit.YARD), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {
        // Explicit target = CENTIMETERS: 1in + 1in = ~5.08 CM
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2, LengthUnit.CM);
        
        assertEquals(5.08, result.toConvert(LengthUnit.CM), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        // Target matches first operand: 2yd + 3ft (1yd) = 3.0 YARDS
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.YARD);
        
        assertEquals(3.0, result.toConvert(LengthUnit.YARD), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        // Target matches second operand: 1yd (3ft) + 6ft = 9.0 FEET
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(6.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.FEET);
        
        assertEquals(9.0, result.toConvert(LengthUnit.FEET), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {
        // Commutativity with explicit target: A+B should equal B+A
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        
        QuantityLength res1 = q1.add(q2, LengthUnit.FEET);
        QuantityLength res2 = q2.add(q1, LengthUnit.FEET);
        
        assertEquals(res1.toConvert(LengthUnit.FEET), res2.toConvert(LengthUnit.FEET), DELTA);
        assertEquals(res1, res2);
    }

    @Test
    void testAddition_ExplicitTargetUnit_WithZero() {
        // Zero operand + explicit target: 0yd + 5ft = ~1.667 YARDS
        QuantityLength q1 = new QuantityLength(0.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.YARD);
        
        assertEquals(1.667, result.toConvert(LengthUnit.YARD), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NegativeValues() {
        // Negative values with target: 48in + (-12in) = 36.0 INCHES
        QuantityLength q1 = new QuantityLength(48.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(-12.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2, LengthUnit.INCH);
        
        assertEquals(36.0, result.toConvert(LengthUnit.INCH), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        // Null targetUnit rejected: Expect IllegalArgumentException
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        
        assertThrows(IllegalArgumentException.class, () -> q1.add(q2, null));
    }

    @Test
    void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        // Large -> small unit scale: 250yd + 250yd = 18000.0 INCHES
        QuantityLength q1 = new QuantityLength(250.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(250.0, LengthUnit.YARD);
        QuantityLength result = q1.add(q2, LengthUnit.INCH);
        
        assertEquals(18000.0, result.toConvert(LengthUnit.INCH), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        // Small -> large unit scale: 12in + 12in = ~0.667 YARDS
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2, LengthUnit.YARD);
        
        assertEquals(0.667, result.toConvert(LengthUnit.YARD), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
        // Verifying mixed addition: 1 Yard + 1 Foot + 12 Inches = 5 Feet
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength foot = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);
        
        QuantityLength sum = yard.add(foot, LengthUnit.FEET).add(inch, LengthUnit.FEET);
        
        assertEquals(5.0, sum.toConvert(LengthUnit.FEET), DELTA);
    }

    @Test
    void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
        // Epsilon-based float comparison: Within tolerance (1e-6)
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        // Slightly offset but within your code's EPSILON (1e-6)
        QuantityLength q2 = new QuantityLength(1.0000001, LengthUnit.FEET);
        
        assertEquals(q1, q2, "Quantities should be equal based on internal EPSILON");
    }
 
       
    }
    
