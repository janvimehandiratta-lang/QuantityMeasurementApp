package com.quantity.measurement;
import com.quantity.measurement.model.QuantityLength;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quantity.measurement.enumImpl.LengthUnit;
import com.quantity.measurement.enumImpl.WeightUnit;
import com.quantity.measurement.model.QuantityWeight;
import java.util.Scanner;

@SpringBootApplication
public class MeasurementApplication {
    public static void main(String[] args) {

        QuantityLength length1 = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength length2 = new QuantityLength(12.0, LengthUnit.INCH);
    }
}