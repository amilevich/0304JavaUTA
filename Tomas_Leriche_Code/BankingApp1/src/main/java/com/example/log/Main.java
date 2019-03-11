package com.example.log;

import org.apache.log4j.Logger;

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		if(logger.isInfoEnabled()) {
			logger.info("this is info");
		}
		
		logger.info("this is info");
		logger.error("message about error ", new IndexOutOfBoundsException());
		logger.fatal("fatal message");
		logger.warn("warning message");
		
		
	}
	
}
