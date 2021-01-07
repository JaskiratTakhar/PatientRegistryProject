package com.fdmgroup.controller;

import javax.persistence.NoResultException;

import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.DashBoardView;
import com.fdmgroup.view.HomeView;


public class AuthenticationController {
private IUserDao userDao;
private DashBoardView dashboardView;
	private HomeView hv;
	

	public void login(String username, String password) throws NoResultException{		
	
		try {
			User user = userDao.findByUserName(username);
			////////////////////////////////////////////////////////////////////////////////////////////////
			if (user != null && user.getPassword().equals(password)) {
				UserSession.setLoggedInUser(user);
				dashboardView.showDashboard();
				
				
			}
			else {
				System.out.println("The username/password entered are incorrect!");
				hv.showLoginOptions(false);
				
			}
		} catch (NoResultException e) {
			
			System.out.println("The username/password entered are incorrect!");
			hv.showLoginOptions(false);
		}
	}
	
	//*******************Check if the username exists or not************////////////
	public void userCheck(String username) throws NoResultException{
		
		try {
			User user = userDao.findByUserName(username);
			if (user != null && user.getUserName().equals(username)) {
				System.out.println("The username entered already exists!");
				System.out.println("Please try a different username");
				hv.showRegisterOptions(false);
			}
			
										
		} catch (NoResultException e) {
			
				hv.comeback();
		}		
				
	}
	public AuthenticationController(IUserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public AuthenticationController() {
		super();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public DashBoardView getDashboardView() {
		return dashboardView;
	}

	public void setDashboardView(DashBoardView dashboardView) {
		this.dashboardView = dashboardView;
	}
		

	public HomeView getHv() {
		return hv;
	}

	public void setHv(HomeView hv) {
		this.hv = hv;
	}

}
