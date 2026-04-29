package com.quantity.measurement.model;

import com.quantity.measurement.enums.LengthUnit; 

public class QuantityLength {

    private final Quantity<LengthUnit> quantity;

    // Constructor
    public QuantityLength(double value, LengthUnit unit) {
        this.quantity = new Quantity<>(value, unit);
    }

    // Getters
    public double getValue() {
        return quantity.getValue();
    }

    public LengthUnit getUnit() {
        return quantity.getUnit();
    }

    // =========================
    // ADDITION
    // =========================
    public QuantityLength add(QuantityLength other) {
        if (other == null)
            throw new NullPointerException("Other cannot be null");

        Quantity<LengthUnit> result = quantity.add(other.quantity);
        return new QuantityLength(result.getValue(), result.getUnit());
    }

    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null)
            throw new NullPointerException("Arguments cannot be null");

        Quantity<LengthUnit> result = quantity.add(other.quantity, targetUnit);
        return new QuantityLength(result.getValue(), result.getUnit());
    }

    // =========================
    // SUBTRACTION (UC12)
    // =========================
    public QuantityLength subtract(QuantityLength other) {
        if (other == null)
            throw new NullPointerException("Other cannot be null");

        Quantity<LengthUnit> result = quantity.subtract(other.quantity);
        return new QuantityLength(result.getValue(), result.getUnit());
    }

    public QuantityLength subtract(QuantityLength other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null)
            throw new NullPointerException("Arguments cannot be null");

        Quantity<LengthUnit> result =
                quantity.subtract(other.quantity, targetUnit);

        return new QuantityLength(result.getValue(), result.getUnit());
    }

    // =========================
    // DIVISION (UC12)
    // =========================
    public double divide(QuantityLength other) {
        if (other == null)
            throw new NullPointerException("Other cannot be null");

        return quantity.divide(other.quantity);
    }

    // =========================
    // CONVERSION
    // =========================
    public QuantityLength toConvert(LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new NullPointerException("Target unit cannot be null");

        Quantity<LengthUnit> result = quantity.toConvert(targetUnit);
        return new QuantityLength(result.getValue(), result.getUnit());
    }

    // =========================
    // EQUALITY
    // =========================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        QuantityLength that = (QuantityLength) o;

        return this.quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return quantity.hashCode();
    }
}