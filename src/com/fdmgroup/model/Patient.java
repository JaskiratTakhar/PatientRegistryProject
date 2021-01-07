package com.fdmgroup.model;

import javax.persistence.Entity;

@Entity

public class Patient extends User{

	private String healthIssue;

	
	public Patient() {
		super();
	}

	public Patient(String username, String password, String firstName, String lastName, String healthIssue) {
		super(username, password, firstName, lastName);
		this.healthIssue = healthIssue;
	}

	public Patient(String healthIssue) {
		super();
		this.healthIssue = healthIssue;
	}

	public String getHealthIssue() {
		return healthIssue;
	}

	public void setHealthIssue(String healthIssue) {
		this.healthIssue = healthIssue;
	}

	@Override
	public String toString() {
		return "Patient [healthIssue=" + healthIssue + "]";
	}

	
	
}
