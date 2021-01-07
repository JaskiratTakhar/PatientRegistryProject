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
 * Servlet implementation class CancelAppointmentServlet
 */
@WebServlet("/CancelAppointmentServlet")
public class CancelAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelAppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userId");
		System.out.println(id);
		ApptDao apptDao = new ApptDao();
		Appointment appointment = apptDao.viewAppointments(id);
		if(appointment != null ) {
			apptDao.removeAppointments(id);
			session.setAttribute("WelcomeMsg","Appointment Cancelled!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientOptionView.jsp");
			dispatcher.forward(request, response);
		}
		else  {
			
			session.setAttribute("WelcomeMsg","No Appointments Found!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientOptionView.jsp");
			dispatcher.forward(request, response);
		}
				
	}

}
