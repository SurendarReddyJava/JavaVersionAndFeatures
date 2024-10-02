package com.soori.java8.stream;

class Address {
	private String hno;
	private String street;
	private String area;
	private String dist;
	private String state;
	private String pincode;
	private String type; // home, office
	private boolean isPrimary;

	public Address(String hno, String street, String area, String dist, String state, String pincode, String type,
			boolean isPrimary) {
		this.hno = hno;
		this.street = street;
		this.area = area;
		this.dist = dist;
		this.state = state;
		this.pincode = pincode;
		this.type = type;
		this.isPrimary = isPrimary;
	}

	// Getters and toString() method
	public String getHno() {
		return hno;
	}

	public String getStreet() {
		return street;
	}

	public String getArea() {
		return area;
	}

	public String getDist() {
		return dist;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	public String getType() {
		return type;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	@Override
	public String toString() {
		return hno + ", " + street + ", " + area + ", " + dist + ", " + state + ", " + pincode + ", " + type + ", "
				+ (isPrimary ? "Primary" : "Secondary");
	}
}