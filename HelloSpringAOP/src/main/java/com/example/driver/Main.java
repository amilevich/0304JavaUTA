package com.example.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.myapp.MyAppProxy;

public class Main {

	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("Andrew.xml");
		
		MyAppProxy app = appCon.getBean("appProxy", MyAppProxy.class);
		
		app.drawCartoon();
		app.drawMiniCartoon(5);
		app.drawNature();
		app.sculptPottery();

	}

}
