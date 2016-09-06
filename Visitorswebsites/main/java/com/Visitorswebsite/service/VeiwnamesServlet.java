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

import utils.database.ConnectionJDBCFactory;


@WebServlet("/VeiwnamesServlet")
public class VeiwnamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	public void destroy() {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("val");
		PrintWriter out=response.getWriter();
		if(id.length()>0 ){
			try{
			conn=ConnectionJDBCFactory.getInstance().getConnection();
   
			String query="select * from visitors where ID=? order by ID limit 8";
            
			PreparedStatement pstmt=conn.prepareStatement(query);
	        pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			out.println("<hr>");
			out.println("<table border=1 cellpadding=5 cellspacing=4>");
			out.println("<tr><th>ID</th><th>NAME</th> <th>DISCRIPTION</th> <th>TELEPHONE</th> <th>IDNUMBER</th> <th>GENDER</th> <th>ADDRESS</th> <th>EMAILADDRESS</th> <th>TIME</th> </tr>");
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>" +rs.getString(1)+"</td>");
				out.println("<td>" +rs.getString(2)+"</td>");
				out.println("<td>" +rs.getString(3)+"</td>");
				out.println("<td>" +rs.getString(4)+"</td>");
				out.println("<td>" +rs.getString(5)+"</td>");
				out.println("<td>" +rs.getString(6)+"</td>");
				out.println("<td>" +rs.getString(7)+"</td>");
				out.println("<td>" +rs.getString(8)+"</td>");
				out.println("<td>" +rs.getString(9)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			conn.close();
			}catch(Exception e){e.printStackTrace();}
	}
	}
}
