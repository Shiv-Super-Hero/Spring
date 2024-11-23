package com.shivaji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shivaji.command.User;

@Controller
@RequestMapping("/reg")
public class UserController {
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("user",new User());
		return "registrationform";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView registration(User user,BindingResult errors,Model model) {
		if(errors.hasErrors()) {
			return new ModelAndView("registrationform","user",user);
		}else {
			return new ModelAndView("registrationdetails","user",user);
		}
		
		// Due to lack of jar files the further development of the program is stopped here.
		
	}
}
