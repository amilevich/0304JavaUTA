package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.example.controller.RequestHelper;


public class MasterServlet extends HttpServlet{
	
	public static Logger logger = null;
	public void init() {
		logger = Logger.getRootLogger();
		BasicConfigurator.configure();
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestHelper.process(request, response);
        logger.info("doGet");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String targetURL = RequestHelper.process(request, response);
        request.getRequestDispatcher(targetURL).forward(request, response);
        logger.info("doPost");
       
    }
    
 
}
