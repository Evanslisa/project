package com.Visitorswebsite.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Visitorswebsite.DaoImp.AdminstratorDaolmp;
import com.Visitorswebsite.model.Adminstrator;


@WebServlet("/AdminstratorServlet")
public class AdminstratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	PreparedStatement pstmt=null;
	int inserted=0;
    static int counter=1;
	public void destroy() {
		System.out.println("Servlet destroyed...");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		Adminstrator admins=new Adminstrator();	
	    admins.setUsername(request.getParameter("username"));
	    admins.setPassword(request.getParameter("password"));
	    admins.setRepassword(request.getParameter("repassword"));
	    admins.setPhone(request.getParameter("phone"));
	    admins.setAddress(request.getParameter("address"));
	    AdminstratorDaolmp admin=new AdminstratorDaolmp();
	    admin.saveadmin(admins);
	    if(admin.equals("")){
			 out.println("Your record is not saved in the database....");	
			  
		}else {
			out.println("You  have  registered with us successfully thanks for useing our system ...." +"Your Number is"+ counter++);
//			 out.println("Your record is saved in the database....");
//			 response.sendRedirect("./Loginpage.jsp");
		}
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

}
