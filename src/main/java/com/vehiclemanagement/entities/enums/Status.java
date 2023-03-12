package com.vehiclemanagement.entities.enums;

public enum Status {

	TO_SELL(1), SOLD(2);

	private int code;

	private Status(int code) {
		this.code = code;

	}

	public int getCode() {
		return code;

	}

	public static Status valueOf(int code) throws IllegalAccessException {
		for (Status value : Status.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalAccessException("Invalid Code");
	}
}
