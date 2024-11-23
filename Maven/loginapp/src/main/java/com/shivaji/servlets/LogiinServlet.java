package com.shivaji.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shivaji.services.UserService;

/**
 * Servlet implementation class LogiinServlet
 */
public class LogiinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		UserService userService = new UserService();
		String status = userService.checkLogin(uname, upwd);
		RequestDispatcher requestDispatcher = null;
		
		if(status.equals("success")) {
			requestDispatcher = request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);
		}else {
			requestDispatcher = request.getRequestDispatcher("failure.html");
			requestDispatcher.forward(request, response);
		}
	}

}
