package com.Project1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project1.DaoImpl.ReimbursementDaoImpl;
import com.Project1.Model.Reimbursement;
import com.Project1.Model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EHomeController {
	public static String Ticket(HttpServletRequest request) {
        String temp = request.getParameter("Amount");
        int Amount = Integer.parseInt(temp);
        temp = request.getParameter("Type");
        int Type = Integer.parseInt(temp);
        String Describe = request.getParameter("Describe");
        
        
        User user = (User) request.getSession().getAttribute("User");
        
        Reimbursement reim = new Reimbursement();
        reim.setReimbursementAmount(Amount);
        reim.setReimbursementAuthor(user.getUserId());
        reim.setReimbursementDescription(Describe);
        reim.setReimbursementTypeId(Type);
        reim.setReimbursementStatusId(0);
        
        
        ReimbursementDaoImpl IReim = new ReimbursementDaoImpl();
        reim.setReimbursementId(Math.max(IReim.returnMaxReimbursementId(),0)+1);
        IReim.insertReimbursement(reim);
        
        return "/html/EHome.html";
    }

	public static String Logout(HttpServletRequest request) {
        
        return "/html/Login.html";
    }
    
    public static String Data(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("User");
        List<Reimbursement> reim = new ArrayList<Reimbursement>();
        ReimbursementDaoImpl IReim = new ReimbursementDaoImpl();
        reim = IReim.selectReimbursementsByAuthor(user.getUsername());
        
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(reim));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return "";
    }
	
}
