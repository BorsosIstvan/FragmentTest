package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/contacts")
	public String listContacts() {
		return "index";
	}
	@GetMapping("/users")
	public String listUsers() {
		return "index";
	}
	@GetMapping("/logout")
	public String loggingOut() {
		return "index";
	}

}
