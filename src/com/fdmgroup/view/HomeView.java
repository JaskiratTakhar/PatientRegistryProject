package com.fdmgroup.view;


import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.RegisterationController;

public class HomeView {

	private Scanner scanner;
	private AuthenticationController authenticationController;
	private RegisterationController registrationController;

	public HomeView(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public AuthenticationController getAuthenticationController() {
		return authenticationController;
	}

	public void setAuthenticationController(AuthenticationController authenticationController) {
		this.authenticationController = authenticationController;
	}

	public RegisterationController getRegistrationController() {
		return registrationController;
	}

	public void setRegistrationController(RegisterationController registrationController) {
		this.registrationController = registrationController;
	}

	public void comeback() {
		// this function returns the executing code back to the method//
	}

	public void showInitialOptions(boolean showMessageOnMain) {

		if (showMessageOnMain) {
		}
		;

		System.out.println("Invalid Option");
		System.out.println("Welcome to my Solo Project Version 1.0.0");
		System.out.println("Please choose one of the options below:");
		System.out.println("1) Login");
		System.out.println("2) Register");
		System.out.println("3) Logout");

		System.out.println("*****************************");

		String userInput = scanner.next();
		switch (userInput) {
		case "1":
			showLoginOptions(false);
			break;
		case "2":
			showRegisterOptions(false);
			break;

		case "3":
			System.out.println("Thanks, Goodbye!");
			System.exit(0);
			break;
		default:
			System.out.println("Wrong Input Try again");
			showInitialOptions(false);
		}
	}

	public void showLoginOptions(boolean showErrMessage) {

		String username, password, password2;

		if (showErrMessage) {
			System.out.println("Username/Password is wrong.");
		}

		System.out.println("Login");
		System.out.println("Please enter username: ");
		username = scanner.next();
		System.out.println("Please enter password: ");
		password = scanner.next();
		System.out.println("Please renter the password: ");
		password2 = scanner.next();

		if (password.equals(password2)) {

			authenticationController.login(username, password);
		} else {
			System.out.println("The entered password doesn't match.");
			System.out.println("Please reneter the userName and Password");
			showLoginOptions(false);
		}
	}

	public void showRegisterOptions(boolean showError) {

		if (showError) {
			System.out.println("Invalid. Try again");
			showInitialOptions(false);
		}

		System.out.println("Tell us more about yourself?");
		System.out.println("Select from the following options");
		System.out.println("1. Doctor");
		System.out.println("2. Receptionist");
		System.out.println("3. Patient");
		System.out.println("4. To go back to the Initial Options");
		System.out.println("5. Logout and Exit");

		String input = scanner.next();

		switch (input) {
		case "1":
			createAndEnterDataForDoctor(false);
			break;
		case "2":
			createAndEnterDataForReceptionist(false);
			break;
		case "3":
			createAndEnterDataForPatient(false);
			break;
		case "4":
			showInitialOptions(false);
			break;

		case "5":
			System.exit(0);
			break;

		default:
			System.out.println("Wrong Input Try again");
			showRegisterOptions(false);
			break;
		}

	}

	private void createAndEnterDataForPatient(boolean b) {
		String username, password, firstName,lastName,healthIssue;

		System.out.println("Please enter your Credentials to Register");
		System.out.println("Please enter username: ");
		username = scanner.next();

		authenticationController.userCheck(username);
		comeback();
		System.out.println("Please enter password: ");
		password = scanner.next();
		System.out.println("Please enter firstName: ");
		firstName = scanner.next();
		System.out.println("Please enter lastName: ");
		lastName = scanner.next();
		System.out.println("Please enter your HealthIssue: ");
		healthIssue = scanner.next();

		registrationController.registerforPatient(username, password, firstName, lastName, healthIssue);
		showLoginOptions(false);
	}

	private void createAndEnterDataForReceptionist(boolean b) {
		String username, password,firstName,lastName,deskNo;

		System.out.println("Please enter your Credentials to Register");
		System.out.println("Please enter username: ");
		username = scanner.next();

		authenticationController.userCheck(username);
		comeback();
		System.out.println("Please enter password: ");
		password = scanner.next();
		System.out.println("Please enter firstName: ");
		firstName = scanner.next();
		System.out.println("Please enter lastName: ");
		lastName = scanner.next();
		System.out.println("Please enter your deskNo: ");
		deskNo = scanner.next();

		registrationController.registerforReceptionist(username, password, firstName, lastName, deskNo);
		showLoginOptions(false);
	}

	public void createAndEnterDataForDoctor(boolean b) {
		String username, password,firstName,lastName,specialization;

		System.out.println("Please enter your Credentials to Register");
		System.out.println("Please enter username: ");
		username = scanner.next();
		authenticationController.userCheck(username);
		comeback();
		System.out.println("Please enter password: ");
		password = scanner.next();
		System.out.println("Please enter firstName: ");
		firstName = scanner.next();
		System.out.println("Please enter lastName: ");
		lastName = scanner.next();
		System.out.println("Please enter your specialization: ");
		specialization = scanner.next();
		registrationController.registerforDoctor(username, password, firstName, lastName, specialization);
		showLoginOptions(false);
	}
}
