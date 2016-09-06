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

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PreparedStatement ps=null;
    static Connection conn=null;
    static ResultSet rs=null;
    static int counter=0;
    static int temp=0;
	
	public void destroy() {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			String mid=request.getParameter("id");
			int id=Integer.parseInt(mid);
		    System.out.println(id);
			out.println("Customer  number:"  + id +"Updated successfully" );
		    out.println("<input type=hidden name=\"id\" value="+ id+">");
		    String username=request.getParameter("username");
			String password=request.getParameter("password");
			String repassword=request.getParameter("repassword");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			ps=conn.prepareStatement("update adminstrator set  USERNAME='"+username+"', PASSWORD='"+password+"', REPASSWORD='"+repassword+"', PHONENUMBER='"+phone+"', ADDRESS='"+address+"' where ID='"+id+"'");
			counter=ps.executeUpdate();
			temp++;
			if(counter>0){
				
				out.println("Your record is successfuly updated........");
			}else {
				out.println("your record is not update try again later..");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
