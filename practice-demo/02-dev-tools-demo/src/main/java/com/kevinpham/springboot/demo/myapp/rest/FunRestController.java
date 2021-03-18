package com.kevinpham.springboot.demo.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	// expose endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a heard 5k!";
	}

	// expose endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day!";
	}
}
