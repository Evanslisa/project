package com.Visitorswebsite.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Visitorswebsite.DaoImp.LoginDaolmp;
import com.Visitorswebsite.model.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int temp=0;
//    static int counter=0;
	
	public void destroy() {
		System.out.println("Servlet destroyed...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Login bean=new Login();
		bean.setUsername(username);
		bean.setPassword(password);
		bean=LoginDaolmp.login(bean);
         
		try {
			if(bean.isValid()){
				HttpSession session=request.getSession(true);
				session.setAttribute("bean", bean);	
//				out.println("You have successfully logged in" +"Your No:"+ counter++);
				out.println("You have successfully logged in");
				response.sendRedirect("./Homepage.jsp");
					}else{ 
				   out.println("Error,Sorry! Username or Password Error. Plz Enter Correct Detail...");
					}	
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

}
