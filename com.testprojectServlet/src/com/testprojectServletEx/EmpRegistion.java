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

import com.testbean.Employee;
import com.testprojectDBConnection.DAOoperations;
import com.testprojectDBConnection.DataBaseConnection;

/**
 * Servlet implementation class EmpRegistion
 */
@WebServlet( description = "Employe Registation Form", urlPatterns = {"/EmpRegistion"} )
public class EmpRegistion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpRegistion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("LastName");
		String name=firstName+" "+lastName;
		String Mail_Id=request.getParameter("MailId");
		String Password=request.getParameter("password");
		String conform_Password=request.getParameter("cpassword");
		String Mobile_Number=request.getParameter("Number");
		int mobileNumber=0;
		
		try{
			mobileNumber=Integer.parseInt(Mobile_Number);
			
		}catch(Exception e){
			
			mobileNumber=0;
			
		}
		
		
		
	Employee e=new Employee();
	e.setName(name);
	e.setMailId(Mail_Id);
	e.setPassword(Password);
	e.setConformPassword(conform_Password);
	e.setMobileNumber(mobileNumber);
	
	DAOoperations dao=new DAOoperations();
	int result=dao.InsertData(e);
	
	
	RequestDispatcher requestdispatch=request.getRequestDispatcher("index.html");
	
	HttpSession session=request.getSession();
	session.setAttribute("Name",name);
	
	if(result>0){
		requestdispatch.forward(request, response);
	}
	
	
	}
	
	

}
