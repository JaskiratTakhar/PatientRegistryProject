package com.fdmgroup.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "ALL_APPOINTMENT")
@NamedQueries({
	@NamedQuery(name = "Appointment.findAllAppointments" , query = "Select appt from Appointment appt where appt.user.id = :lId"),
	@NamedQuery(name = "Appointment.removeAppointments" , query = "Delete from Appointment appt where appt.user.id = :lId"),
	@NamedQuery(name ="Appointment.CheckAppointmentSchedule" , query ="Select appt.time from Appointment appt where appt.doctor = :dDoctor and appt.appointment_date =:dDate and appt.time =:tTime")
})
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "mySeq", initialValue = 1,allocationSize = 1)

	int id;
	String appointment_date;
	String time;
	String doctor;
	String status;
	String healthIssue;

	@OneToOne (cascade = CascadeType.REMOVE)
	@JoinColumn(name = "FK_USER_ID")
	private User user;

	public Appointment() {
		super();
	}
	     
	public Appointment( String doctor, String date, String appointmenttime, String status,String healthIssue, User user) {
		super();
		this.user = user;
		this.appointment_date = date;
		this.time = appointmenttime;
		this.doctor = doctor;
		this.status = status;
		this.healthIssue=healthIssue;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return appointment_date;
	}

	public void setDate(String date) {
		this.appointment_date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;

	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + appointment_date + ", time=" + time + ", doctor=" + doctor + ", status="
				+ status + ", user=" + user + "]";
	}
}
