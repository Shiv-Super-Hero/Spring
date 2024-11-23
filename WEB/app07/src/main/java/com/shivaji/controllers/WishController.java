package com.shivaji.controllers;

import java.time.LocalTime; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishController extends AbstractController {
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		String wish_Message = "";
		if(hour < 12) {
			wish_Message = "Good Morning";
		}else if(hour < 17) {
			wish_Message = "Good After Noon";
		}else {
			wish_Message = "Good Evening";
		}
		
		return new ModelAndView("wish", "message", wish_Message);
	}

}
