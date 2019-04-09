package com.example.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.VillainService;
import com.example.service.VillainServiceImpl;

public class Main {

	/*
	 * WHAT IS SPRING?
	 * Model-based, open source framework.
	 * It provides support for enterprise level
	 * applications; it provides infrastructure
	 * so that you can focus on your application's
	 * business logic
	 * 
	 * Benefits of Dependency Injection:
	 * - decoupling of code
	 * - testability
	 * - maintainability
	 * - scalability
	 * - reduces complexity
	 * 
	 * Scopes of a Spring Bean:
	 * - Singleton (default)
	 * - Prototype - it means you can have multiple
	 * instances of the bean within the container
	 * - Request - exists within the HTTP request
	 * - Session - exists within the HTTP Session
	 * - GlobalSession - exists within all HTTP sessions
	 */
	private static VillainService vServ = new VillainServiceImpl();
	
	public static void main(String[] args) {
		// Containers that Spring provides
	// applicationContext - is a BeanFactory, it
	// inherits from a BeanFactory interface.
	// text messaging extra stuff
	// BeanFactory - the simplest container providing
		//basic support for DI.
	//BeanFactory is no longer the preferred container
		// to use.
	//ApplicationContext extends BeanFactory and
		// adds more enterprise-specific functionality
		
	ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	
	vServ = appContext.getBean("villainService", VillainService.class);
	System.out.println(vServ.getAllVillains());
	}

}
