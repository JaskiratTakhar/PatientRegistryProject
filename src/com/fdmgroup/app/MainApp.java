package com.fdmgroup.app;

import java.util.Scanner;

import com.fdmgroup.controller.AppointmentController;
import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.controller.RegisterationController;
import com.fdmgroup.dao.ApptDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.view.ApptView;
import com.fdmgroup.view.DashBoardView;

import com.fdmgroup.view.HomeView;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IUserDao userdao = new UserDaoJpaImpl();
        
		HomeView hv = new HomeView(scanner);
		DashBoardView dv = new DashBoardView(scanner);
		ApptView apv = new ApptView(scanner);
		ApptDao aptDao  = new ApptDao();
 		
		HomeController hc = new HomeController();
		AuthenticationController ac = new AuthenticationController();
		RegisterationController rc = new RegisterationController();
		AppointmentController apc = new AppointmentController();

		// set the states2
        ac.setUserDao(userdao);
        ac.setDashboardView(dv);
        ac.setUserDao(userdao);
		hc.setHomeView(hv);
		hv.setAuthenticationController(ac);
        rc.setUserDao(userdao);
        rc.setHomeView(hv);		
        hv.setRegistrationController(rc); 
        
        //my created setters
        ac.setHv(hv);
        dv.setAppointment(apv);
        apv.setUserDao(userdao);
        apv.setAppointmentController(apc);
        apc.setUserDao(userdao);
        apc.setApptDao(aptDao);
        apv.setApptdao(aptDao);
        aptDao.setDashBoardView(new DashBoardView());
        
        //program execution begins here        
		hc.showHome();
        
	}
}
