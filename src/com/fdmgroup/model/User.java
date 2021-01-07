package com.fdmgroup.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "ALL_USER")
@NamedQueries({
@NamedQuery(name = "User.findAllUsers" , query = "Select u from User u where u.userName = :lName")
})
public class User implements IStorable{//IStorable is just a marker..does nothing at all
@Id
@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
@SequenceGenerator (name = "USER_SEQ", sequenceName = "USER_SEQ",initialValue = 1,allocationSize = 1)
	private int id;


	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	@OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
	
	private Appointment appointment;
	
	public User() {
		super();
	}
	
		public User(String userName, String password, String firstName, String lastName) {
		super();		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
}
