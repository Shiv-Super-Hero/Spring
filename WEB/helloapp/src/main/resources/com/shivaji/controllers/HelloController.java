package com.shivaji.controllers;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("message")
public class HelloController {
	
	@RequestMapping("/hellopage")
	public String helloPage() {
		return "helloform";
	}
	
	@RequestMapping("/wish")
	public String wish(@RequestParam("uname") String uname, ModelMap map) {
		map.addAttribute("message","Hello "+uname+"!");
		return "wish";
	}
	
}
