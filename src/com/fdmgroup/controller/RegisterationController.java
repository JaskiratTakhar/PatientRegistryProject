package com.fdmgroup.controller;

import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.Doctor;
import com.fdmgroup.model.Patient;
import com.fdmgroup.model.Receptionist;

import com.fdmgroup.view.HomeView;

public class RegisterationController {

	private HomeView homeView;
	private IUserDao userDao;
	
	
public void registerforDoctor(String username, String password, String firstName, String lastName,String specialization) {
		
		userDao.createTable(new Doctor(username, password, firstName, lastName,specialization));
		
	//	homeView.showLoginOptions(false); 
	}


public HomeView getHomeView() {
	return homeView;
}


public void setHomeView(HomeView homeView) {
	this.homeView = homeView;
}


public IUserDao getUserDao() {
	return userDao;
}


public void setUserDao(IUserDao userDao) {
	this.userDao = userDao;
}
public void registerforPatient(String username, String password, String firstName, String lastName,	String healthIssue) {
	userDao.createTable(new Patient(username, password, firstName, lastName,healthIssue));
	
}


public void registerforReceptionist(String username, String password, String firstName, String lastName,String deskNo) {
	userDao.createTable(new Receptionist(username, password, firstName, lastName,deskNo));
	
}
	
}
