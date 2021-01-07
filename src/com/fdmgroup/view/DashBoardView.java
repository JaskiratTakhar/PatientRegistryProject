package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.UserSession;

public class DashBoardView {
	private Scanner scanner;

	private ApptView appointmentview;

	public DashBoardView() {
		super();
	}

	public DashBoardView(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public DashBoardView(Scanner scanner, AuthenticationController authenticationController) {
		super();
		this.scanner = scanner;
		// this is purposely missing the authentication controller
	}

	public void showDashboard() {
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstName() + " "
				+ UserSession.getLoggedInUser().getLastName() + "!");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Book a new Appointment");
		System.out.println("2) Check my Appointment");
		System.out.println("3) Remove my Appointment");
		System.out.println("4) Exit Application");

		String userInput = scanner.next();

		switch (userInput) {
		case "1":
			appointmentview.showBookingOptions();
			showDashboard();
			break;
		case "2":
			appointmentview.checkAppointments();
			showDashboard();
		case "3":
			appointmentview.removeAppointments();
			showDashboard();
		default:
			System.out.println("The input was invalid.");
			showDashboard();
			break;
		}
	}

	public ApptView getAppointment() {
		return appointmentview;
	}

	public void setAppointment(ApptView appointment) {
		this.appointmentview = appointment;
	}

}
