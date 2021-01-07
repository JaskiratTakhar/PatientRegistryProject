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

import com.fdmgroup.model.Appointment;


/**
 * Servlet implementation class ViewAppointmentServlet
 */
@WebServlet("/ViewAppointmentServlet")
public class ViewAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAppointmentServlet() {
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
		Appointment appointment = apptDao.viewAppointments(id);
		if(appointment!=null) {
			session.setAttribute("doctorMsg", appointment.getDoctor());
			session.setAttribute("dateMsg",appointment.getDate());
			session.setAttribute("statusMsg",appointment.getStatus());
			session.setAttribute("timeMsg",appointment.getTime());
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/viewAppointments.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			request.setAttribute("WelcomeMsg","No Appointment found!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientOptionView.jsp");
			dispatcher.forward(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
