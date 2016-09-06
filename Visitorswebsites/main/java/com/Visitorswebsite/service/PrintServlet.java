package com.Visitorswebsite.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Visitorswebsite.model.Visitors;


@WebServlet("/PrintServlet")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	PreparedStatement pstmt=null;
	static ResultSet rs=null;
	public void destroy() {
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=new PrintWriter(response.getWriter());
		out.println("<html>");
		out.println("<head>");
		out.println("<script>function Printer(){ window.print} </script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> THIS IS A  PROJECT FOR DIGITAL AFRICA SERVICE LIMITED</H1>");
		out.println("<PRE> YOU ARE WELCOME TO WORK WITH DIGITAL AFRICA SERVICE LIMITED</PRE>");
		out.println("");
		out.println("");
		out.println("<table border=0 cellpadding=2 cellspacing=4>");
		try {
			int id =Integer.parseInt(request.getParameter("val"));
			if(id>0){
				Visitors bean=VisitorsDaoImp(id);
				out.println("Your Editing Employee ID Number" + id);
	            out.print("<table border=0 cellpadding=2 cellspacing=4>");
				out.println("<tr><td> Name <input type=text name=firstname value="+bean.getName()+" size=40> </td></tr>");
				out.println("<tr><td>Telephone:  <input type=text name=lastname value="+bean.getTelephone()+" size=40></td></tr> ");
				out.println("<tr><td>ID NO:  <input type=text name=idnumber value="+bean.getIdnumber()+" size=40></td></tr> ");
				out.println("<tr><td>Gender  <input type=text name=dateofbirth value="+bean.getGender()+" size=40></td></tr> ");
				out.println("<tr><td>Address  <input type=text name=phoneNumber value="+bean.getAddress()+" size=40></td></tr> ");
				out.println("<tr><td>EmailAddress  <input type=text name=zipcode value="+bean.getEmailAddress()+" size=4></td></tr> ");
				out.println("<tr><td>Dis  <input type=text name=gender value="+bean.getDis()+" size=10></td></tr> ");
				out.println("<tr><td> <input type=submit  value=\" Update\" size=40></td></tr> ");
					
			}
			
			
	    	} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		     }
		out.println("</table>");
		out.println("</html>");
	}

	
	private Visitors VisitorsDaoImp(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  service(request, response);
	}

}
