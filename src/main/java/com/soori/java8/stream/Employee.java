package com.soori.java8.stream;

import java.time.LocalDate;
import java.util.List;

class Employee {
	private int eid;
	private String eName;
	private double eSal;
	private LocalDate eDOB;
	private String eBranch;
	private List<Address> addresses;

	public Employee(int eid, String eName, double eSal, LocalDate eDOB, String eBranch, List<Address> addresses) {
		this.eid = eid;
		this.eName = eName;
		this.eSal = eSal;
		this.eDOB = eDOB;
		this.eBranch = eBranch;
		this.addresses = addresses;
	}

	// Getters and toString() method
	public int getEid() {
		return eid;
	}

	public String getEName() {
		return eName;
	}

	public double getESal() {
		return eSal;
	}

	public LocalDate getEDOB() {
		return eDOB;
	}

	public String getEBranch() {
		return eBranch;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	@Override
	public String toString() {
		return "Employee{" + "eid=" + eid + ", eName='" + eName + '\'' + ", eSal=" + eSal + ", eDOB=" + eDOB
				+ ", eBranch='" + eBranch + '\'' + ", addresses=" + addresses + '}';
	}
}