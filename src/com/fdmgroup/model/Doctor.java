package com.fdmgroup.model;

import javax.persistence.Entity;

@Entity

public class Doctor extends User{
private String specialization;


public Doctor() {
	super();
}

public Doctor(String specialization) {
	super();
	this.specialization = specialization;
}

public String getSpecialization() {
	return specialization;
}

public void setSpecialization(String specialization) {
	this.specialization = specialization;
}




/*public Doctor(int id, String userName, String password, String firstName, String lastName, String specialization) {
	super(id, userName, password, firstName, lastName);
	this.specialization = specialization;
}*/

public Doctor(String userName, String password, String firstName, String lastName, String specialization) {
	super(userName, password, firstName, lastName);
	this.specialization = specialization;
}

@Override
public String toString() {
	return "Doctor [specialization=" + specialization + ", getUserName()=" + getUserName() + ", getPassword()="
			+ getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + "]";
}


}
