package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String home() {
		return "Welcome home *";
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "Greetings from Spring Boot! I am J @.@";
	}

	@GetMapping("/test")
	public String test() {
		return "This is Julie Testing *_*";
	}
}





