package com.fdmgroup.view;

import java.util.Scanner;




import com.fdmgroup.controller.AppointmentController;
import com.fdmgroup.dao.ApptDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.Appointment;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;

public class ApptView {
	private Scanner scanner;
	private AppointmentController appointmentController;
	private ApptDao apptdao;
	private IUserDao userDao;
	
	
	public ApptView() {
	super();
	}

	public ApptView(Scanner scanner) {
		this.scanner = scanner;
	}

	public void showBookingOptions() {
		String date, appointmenttime, doctor, status,healthIssue;
		System.out.println("************************************************");
		System.out.println("Let us find you an appointment!");

		System.out.println("Please enter your required specifications!");

		System.out.println("Please select from the list of doctors: ");

		doctor = scanner.next();

		System.out.println("Please enter desired date: ");
		date = scanner.next();
		System.out.println("Please enter desired time: ");
		appointmenttime = scanner.next();
		System.out.println("Please type \"confirm\" in order to confirm ");
		status = scanner.next();
		System.out.println("Please state your healthIssue");
		healthIssue= scanner.next();
		String username = UserSession.getLoggedInUser().getFirstName();///Get username from the Usersession
		System.out.println(username);
		
		User user = userDao.findByUserName(username);
		
		System.out.println(user);
		appointmentController.createBooking(doctor, date, appointmenttime, status,healthIssue, user);
        
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userdao) {
		this.userDao = userdao;
	}

	public AppointmentController getAppointmentController() {
		return appointmentController;
	}

	public void setAppointmentController(AppointmentController appointmentController) {
		this.appointmentController = appointmentController;
	}

	//this method is accessed in the DashBoard
	public void checkAppointments() {
		int id = UserSession.getLoggedInUser().getId();
		System.out.println("*******************");
		System.out.println("The Id is " + id);
		System.out.println("*******************");
		///Get username from the Usersession		
		 Appointment appointment = apptdao.viewAppointments(id);
		 System.out.println(appointment);///end point		
	}

	public ApptDao getApptdao() {
		return apptdao;
	}

	public void setApptdao(ApptDao apptdao) {
		this.apptdao = apptdao;
	}

	public void removeAppointments() {
		int id = UserSession.getLoggedInUser().getId();
		System.out.println("*******************");
		System.out.println("The Id is " + id);
		System.out.println("*******************");
		//Get username from the Usersession		
		apptdao.removeAppointments(id);
		///end point
				
	}

	

}
