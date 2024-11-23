package com.shivaji.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String status = "";
		ModelAndView mav = null;
		if(uname.equals("durga") && upwd.equals("durga")) {
			mav = new ModelAndView("success");
		}else {
			mav = new ModelAndView("failure");
		}
		return mav;
	}

}
