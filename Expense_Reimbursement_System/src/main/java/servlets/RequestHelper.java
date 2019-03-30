package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Contollers.EmployeePortalController;
import com.example.Contollers.LoginController;

public class RequestHelper {
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		
		//Login.rev
		case "/Expense_Reimbursement_System/HTML/Login.do" : 
			return LoginController.Login(request, response);
		
		//Emp.rev
		case "/Expense_Reimbursement_System/HTML/SubmitT.do" :
			return EmployeePortalController.SubmitT(request, response);
		
		case "/Expense_Reimbursement_System/HTML/SubmitR.do" :
			return EmployeePortalController.SubmitR(request, response);
//		
		}
		
		return null;
		
	}
}
