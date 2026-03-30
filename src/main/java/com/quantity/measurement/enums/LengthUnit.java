package com.quantity.measurement.enums;

public enum LengthUnit {
	Feet(1.0),
	Inch(1.0/12);
	
	private final double toFeetFactor;
	
	LengthUnit(double toFeetFactor){
		this.toFeetFactor = toFeetFactor;
	}
	public double toFeet(double value) {
		return value*toFeetFactor;
	}
}
