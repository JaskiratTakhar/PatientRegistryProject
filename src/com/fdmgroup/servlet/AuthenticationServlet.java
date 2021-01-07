package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
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
		// TODO Auto-generated method stub
		String userName = request.getParameter("name");
		String passWord = request.getParameter("pwd");
		
		UserDaoJpaImpl userDao = new UserDaoJpaImpl();
		User foundUser = userDao.findByUserName(userName);
		if(foundUser !=null && foundUser.getPassword().equals(passWord)) {
			String name = "Hi " +foundUser.getFirstName();			
			int userId = foundUser.getId();
	
	//************HTTPSESSION set's the attribute and stores in the session***************// 		
			
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("user", foundUser);
			session.setAttribute("userId", userId);
			
			//User check=(User)request.getAttribute("currentGuest");
			
			request.setAttribute("WelcomeMsg", name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientOptionView.jsp");
			dispatcher.forward(request, response);
		}else {
			
			
			request.setAttribute("errorMsg","Couldn't find your Account");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			
		}
	
	}
}
