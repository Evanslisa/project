package com.Visitorswebsite.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.database.ConnectionJDBCFactory;


@WebServlet("/ViewallVisitorsServlet")
public class ViewallVisitorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	PreparedStatement pstmt=null;
	static ResultSet rs=null;
	
	public void destroy() {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter pw=response.getWriter();
	    try {
	    conn=ConnectionJDBCFactory.getInstance().getConnection();
	    String sql="SELECT * FROM  visitors";
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		ResultSetMetaData rsmd= (ResultSetMetaData) rs.getMetaData();
 		int rowcount=rsmd.getColumnCount();
 		pw.println("<html>");
 		pw.println("<head> ");
 		pw.println("<title>");
 		pw.println("</title>");
 		pw.println("<link href=ww/style.css rel=stylesheet style=text/css>");
 		pw.println("</head>");
 		pw.println("<body bgcolor=#f0f0ff>");
 		pw.println("<table border=0 cellspacing=2 cellpadding=5 align=center width=50% >" );
 		pw.println("<tr>");
 		for(int x=1;x<=rowcount;x++){
			pw.println("<th>" + rsmd.getColumnLabel(x) + "</th>");
			
		//	pw.println("<hr>");
 		}
 		pw.println("<th>Action/delete</th>");
 		pw.println("</tr>");
		while(rs.next()){
			pw.println("<tr>");
			pw.println("<td>" +rs.getString(1)+"</td>");
			pw.println("<td>" +rs.getString(2)+"</td>");
		    pw.println("<td>" +rs.getString(3)+"</td>");
			pw.println("<td>" +rs.getString(4)+"</td>");
			pw.println("<td>" +rs.getString(5)+"</td>");
			pw.println("<td>" +rs.getString(6)+"</td>");
			pw.println("<td>" +rs.getString(7)+"</td>");
			pw.println("<td>" +rs.getString(8)+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
			
		} catch (Exception e) {																							
			
		}
	}

	
}
