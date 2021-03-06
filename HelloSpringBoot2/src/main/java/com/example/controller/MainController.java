package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("mainController")
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {
	
	@GetMapping("/hello.app")
	public @ResponseBody ResponseEntity<String> getWord(){
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}

}
