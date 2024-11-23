package com.shivaji.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello User, Good Morning!";
	}
}
