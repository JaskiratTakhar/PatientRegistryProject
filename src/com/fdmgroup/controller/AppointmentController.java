package com.fdmgroup.controller;

import javax.persistence.NoResultException;

import com.fdmgroup.dao.ApptDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.Appointment;

import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.DashBoardView;
import com.fdmgroup.view.HomeView;

public class AppointmentController {

	private IUserDao userDao;
	private DashBoardView dashboardView;
	private HomeView hv;
	private ApptDao apptDao;

	public void createBooking(String doctor, String date, String appointmenttime, String status,String healthIssue, User user) {
		Appointment appt = new Appointment(doctor, date, appointmenttime, status, healthIssue, user);
		apptDao.enterDataInBookingTable(appt);

	}

	public void login(String username, String password) throws NoResultException {

		try {
			User user = userDao.findByUserName(username);
			////////////////////////////////////////////////////////////////////////////////////////////////
			if (user != null && user.getPassword().equals(password)) {
				UserSession.setLoggedInUser(user);
				dashboardView.showDashboard();

			} else {
				System.out.println("The username/password entered are incorrect!");
				hv.showLoginOptions(false);

			}
		} catch (NoResultException e) {

			System.out.println("The username/password entered are incorrect!");
			hv.showLoginOptions(false);
		}
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public ApptDao getApptDao() {
		return apptDao;
	}

	public void setApptDao(ApptDao apptDao) {
		this.apptDao = apptDao;
	}

}
