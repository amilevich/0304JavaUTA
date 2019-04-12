package com.projecttwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/next.app", method=RequestMethod.GET)
	public String getPage() {
		return "page";
	}
	
	
	

}
