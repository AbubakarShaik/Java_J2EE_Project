package com.testprojectServletEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testprojectDBConnection.DAOoperations;

/**
 * Servlet implementation class EmpLogin
 */
@WebServlet("/EmpLogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOoperations dao=new DAOoperations();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Mail_Id=request.getParameter("MailId");
		String Password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		if(session!=null){
			session.setAttribute("Mail_Id",Mail_Id);
			
			if(dao.login(Mail_Id,Password)){
				
				RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
				}
			else{
				out.print("<p style=\"color:red\">Sorry username or password error</p>");
				 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		            rd.include(request,response);  
		            }
			out.close();
		}
	}

}
