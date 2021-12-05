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
		return "contacts";
	}
	@GetMapping("/users")
	public String listUsers() {
		return "users";
	}
	@GetMapping("/decoded")
	public String viewDecoded() {
		return "decoded";
	}
	@GetMapping("/logout")
	public String loggingOut() {
		return "index";
	}

}
