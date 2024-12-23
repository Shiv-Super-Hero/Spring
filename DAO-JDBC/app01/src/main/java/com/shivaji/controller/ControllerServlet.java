package com.shivaji.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shivaji.dto.Student;
import com.shivaji.factory.StudentDaoFactory;
import com.shivaji.factory.StudentServiceFactory;
import com.shivaji.service.StudentService;

@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req_Path = request.getRequestURI();
		//System.out.println(req_Path);
		
		StudentService studentService = StudentServiceFactory.getStudentService();
		if(req_Path.endsWith("add.do")) {
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String saddr = request.getParameter("saddr");
			
			Student std = new Student();
			std.setSid(sid);
			std.setSname(sname);
			std.setSaddr(saddr);
			
			String status = studentService.addStudent(std);
			RequestDispatcher requestDispatcher = null;
			if(status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("existed")) {
				requestDispatcher = request.getRequestDispatcher("existed.html");
				requestDispatcher.forward(request, response);
			}
			
		}
		if(req_Path.endsWith("search.do")) {
			String sid = request.getParameter("sid");
			Student std =  studentService.searchStudent(sid);
			RequestDispatcher requestDispatcher = null;
			if(std == null) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			}else {
				request.setAttribute("std", std);
				requestDispatcher = request.getRequestDispatcher("display.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		if(req_Path.endsWith("delete.do")) {
			String sid = request.getParameter("sid");
			String status = studentService.deleteStudent(sid);
			RequestDispatcher requestDispatcher = null;
			if(status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("notexisted")) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			}
		}
	}

}
