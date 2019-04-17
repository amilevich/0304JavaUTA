package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
	
	@Value("${message: Look at this message, it is cool and stuff}")
	private String testString;
	
	@GetMapping("/test")
	public String testMethod() {
		return testString;
	}

}
