package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fdmgroup.dao.UserDaoJpaImpl;
import com.fdmgroup.model.Patient;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String userName = request.getParameter("userName");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String healthIssue = request.getParameter("healthIssue");
				String passWord = request.getParameter("pwd");
				
			
				
				
				UserDaoJpaImpl userDao = new UserDaoJpaImpl();
				User foundUser = userDao.findByUserName(userName);
				
					
					if(foundUser !=null && foundUser.getUserName().equals(userName)) {
						
					System.out.println("The username entered already exists!");
					System.out.println("Please try a different username");	
					request.setAttribute("errorMsg", "UserName already exist!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/patientRegisterView.jsp");
					dispatcher.forward(request, response);		
					
				}	else {
					System.out.println("Registeration Successful!");
					userDao.createTable(new Patient(userName, passWord, firstName, lastName, healthIssue));
					request.setAttribute("errorMsg","Registeration Successful!");
					request.setAttribute("LoginMsg","Please Login Again");
					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login.jsp");
					dispatcher.forward(request, response);		
					
				}
			
			}

		}


