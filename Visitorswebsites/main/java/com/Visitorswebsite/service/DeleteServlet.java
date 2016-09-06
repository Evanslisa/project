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

import utils.database.ConnectionJDBCFactory;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	PreparedStatement pstmt=null;

	public void destroy() {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			String id = request.getParameter("id");
			 String sql="delete from  visitors where ID='"+id+"' ";
			PreparedStatement ps = conn.prepareStatement(sql);
			int temp = ps.executeUpdate();
				if (temp != 0) {
					
					out.println("Row has been deleted successfully");    	
			}
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

}
