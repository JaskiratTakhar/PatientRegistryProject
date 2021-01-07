package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.ApptDao;
import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.model.Appointment;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class PatientOptionServlet
 */
@WebServlet("/PatientAppointmentOptionServlet")
public class PatientOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientOptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userId");
		
		ApptDao apptDao = new ApptDao();
		Appointment appointment = apptDao.viewAppointments(id);//check if you have existing appointment.		
		
		//if no existing appointment
		if(appointment != null ) {
			request.setAttribute("WelcomeMsg","You have one existing Appointment!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientOptionView.jsp");
			dispatcher.forward(request, response);
		
		} 
		//if you have existing appointment
		else {			
				request.setAttribute("WelcomeMsg","Appointment Confirmed!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/patientAppointmentView.jsp");
				dispatcher.forward(request, response);
			}		 
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
