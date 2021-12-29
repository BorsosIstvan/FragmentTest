package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpson.Encoding;
import com.test.test;

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
	@PostMapping("/encode_simpson")
	public String buttonSimpson() throws Throwable {
		Encoding.main(null);
		return "decoded";
	}
	@PostMapping("/encode_adolf")
	public String buttonAdolf() throws Throwable {
		test.main(null);
		return "decoded";
	}

}
