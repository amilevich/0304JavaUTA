package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	/*
	 * By default the DispatcherServlet uses the 
	 * BeanNameUrlHandlerMapping to map the incoming
	 * request.
	 * The BeanNameUrlHandlerMapping uses the bean name as
	 * the URL pattern.
	 * Since it is used by default, you do not need to
	 * create a separate configuration for this
	 */
	
	@RequestMapping(value="/next.app", method = RequestMethod.GET)
	public String getPage() {
		return "page";
	}

}
