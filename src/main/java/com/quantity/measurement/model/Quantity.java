package com.quantity.measurement.model;

import com.quantity.measurement.enums.IMeasurable;
import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 1e-6;
    private final double value;
    private final U unit;

    // Constructor
    public Quantity(double value, U unit) {
        if (unit == null)
            throw new NullPointerException("Unit shouldn't be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    // Getters
    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // =========================
    // CONVERSION
    // =========================
    public Quantity<U> toConvert(U targetUnit) {
        if (targetUnit == null)
            throw new NullPointerException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    // =========================
    // ADDITION
    // =========================
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null || targetUnit == null)
            throw new NullPointerException("Operands must not be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement categories");

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, targetUnit);
    }

    // =========================
    // SUBTRACTION (UC12)
    // =========================

    // Implicit (result in this.unit)
    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    // Explicit target
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        if (other == null || targetUnit == null)
            throw new NullPointerException("Operands must not be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement categories");

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double resultBase = thisBase - otherBase;
        double result = targetUnit.convertFromBaseUnit(resultBase);

       
        

        return new Quantity<>(result, targetUnit);
    }

    // =========================
    // DIVISION (UC12)
    // =========================
    public double divide(Quantity<U> other) {

        if (other == null)
            throw new NullPointerException("Operand must not be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement categories");

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        // ✅ UC12 strict rule
        if (otherBase == 0)
            throw new ArithmeticException("Division by zero");

        return thisBase / otherBase; // no rounding
    }

    // =========================
    // EQUALITY
    // =========================
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (this.unit.getClass() != other.unit.getClass())
            return false;

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < EPSILON;
    }

    @Override
    public int hashCode() {
        double base = unit.convertToBaseUnit(value);
        return Objects.hash(Math.round(base / EPSILON));
    }
}