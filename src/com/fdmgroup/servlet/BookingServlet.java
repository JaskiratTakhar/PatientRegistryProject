package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
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
	@SuppressWarnings("unlikely-arg-type")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		
		String doctor = request.getParameter("doctor");
		String date = request.getParameter("date");
		String appointmenttime = request.getParameter("time");
		String status = "confirmed";
		String healthIssue= request.getParameter("healthIssue");
		
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userId");
		
		ApptDao apptDao = new ApptDao();
		Appointment appointment = apptDao.viewAppointments(id);//check if you have existing appointment.		
		List<Appointment> appointmentScheduleCheck = apptDao.ScheduleCheck(doctor,date,appointmenttime);
		
		if(appointmentScheduleCheck !=null && appointmentScheduleCheck.contains(appointmenttime)) {
			request.setAttribute("errorMsg","Date/Time conflict!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientAppointmentView.jsp");
			dispatcher.forward(request, response);
			
			
		}else {
		
		//if you have existing appointment
		 if(appointment != null ) {
			request.setAttribute("WelcomeMsg","You have one existing Appointment!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientOptionView.jsp");
			dispatcher.forward(request, response);
		
		} 
		//if you dont have existing appointment
		 
		else {
			
			UserDaoJpaImpl userDao = new UserDaoJpaImpl();
			String userName = (String) session.getAttribute("userName");//gets user name from the session
				
			User user = userDao.findByUserName(userName);//get user object from UserDaoImpl
			apptDao.enterDataInBookingTable(new Appointment(doctor, date, appointmenttime, status, healthIssue, user));//enters data in appointment table
			
			request.setAttribute("WelcomeMsg","Appointment Confirmed!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientOptionView.jsp");
			dispatcher.forward(request, response);
			
		}
		 
		}
							
		}

	}

