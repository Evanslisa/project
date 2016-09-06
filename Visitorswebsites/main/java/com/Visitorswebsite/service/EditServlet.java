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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	PreparedStatement pstmt=null;
	static ResultSet rs=null;
	public void destroy() {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=new PrintWriter(response.getWriter());
		try {
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			int id=Integer.parseInt(request.getParameter("id"));
			out.println("YOUR EDITING RECORD NUMBER" + id);
			System.out.println(id);
			String query="select USERNAME, PASSWORD, REPASSWORD, PHONENUMBER, ADDRESS, TIME from adminstrator where  ID='"+id+"'";
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			 out.println("<body bgColor=#eeffee>");
			 out.println("<hr>");
			 out.println("</tr>");
			 out.println("<form action=./UpdateServlet method=get>");
			 out.println("<table align=center border=1 cellpadding=5 cellspacing=3 >");	
			while(rs.next()){
				String username=rs.getString(1);
				String password=rs.getString(2);
				String repassword=rs.getString(3);
				String phone=rs.getString(4);
				String address=rs.getString(5);
				out.println("<tr> <td><input type='hidden' name='id' value='"+id+"'/></td> </tr>");
				out.println("<tr><td><b>USERNAME: </b></td> <td><input type='text' name='username' value='"+username+"' size=40/></tr>");
				out.println("<tr><td><b>PASSWORD: </b></td> <td><input type='text' name='password' value='"+password+"' size=40/> </tr>");
				out.println("<tr><td><b>REPASSWORD: </b></td> <td><input type='text' name='repassword' value='"+repassword+"' size=40/></tr>");
				out.println("<tr><td><b>PHONENUMBER: </b></td> <td><input type='text' name='phone' value='"+phone+"' size=40/> </tr>");
				out.println("<tr><td><b>ADDRESS: </b></td> <td><input type='text' name='address' value='"+address+"' size=40/> </tr>");
				out.println("<tr><td></td><td><input type='submit' style='padding:3px 3px' value='Edit & Update'align=center ></td></tr>");
				out.println("</form>");	
			}
			  out.print("</table>");
	    	} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		     }
	}

}
