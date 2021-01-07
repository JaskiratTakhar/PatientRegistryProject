package com.fdmgroup.model;

import javax.persistence.Entity;

@Entity

public class Receptionist extends User{

	private String deskNo;

	public Receptionist() {
		super();
	}

	public Receptionist(String username, String password, String firstName, String lastName, String deskNo2) {
		super(username, password, firstName, lastName);
		this.deskNo = deskNo2;
	}

	public Receptionist(String deskNo) {
		super();
		this.deskNo = deskNo;
	}

	public String getDeskNo() {
		return deskNo;
	}

	public void setDeskNo(String deskNo) {
		this.deskNo = deskNo;
	}

	@Override
	public String toString() {
		return "Receptionist [deskNo=" + deskNo + "]";
	}
	
	
	
}
