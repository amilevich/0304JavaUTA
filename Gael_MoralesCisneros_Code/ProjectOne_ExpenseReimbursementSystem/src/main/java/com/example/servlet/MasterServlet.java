package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.controller.RequestHelper;


public class MasterServlet extends HttpServlet{
	
	public final static Logger logger = Logger.getLogger(MasterServlet.class.getName());
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestHelper.process(request, response);
        logger.info("doGet: "+"request: "+request+" response: "+response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String targetURL = RequestHelper.process(request, response);
        request.getRequestDispatcher(targetURL).forward(request, response);
        logger.info("doPost: "+"targetURL: "+targetURL + " request: "+request+" response: "+response);
    }
}
