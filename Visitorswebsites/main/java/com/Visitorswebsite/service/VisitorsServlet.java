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

import com.Visitorswebsite.DaoImp.VisitorsDaoImp;
import com.Visitorswebsite.model.Visitors;



@WebServlet("/VisitorsServlet")
public class VisitorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final String sql = null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	int inserted=0;
	
	public void destroy() {
    System.out.println("Servlet destroyed...");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			Visitors books=new Visitors();
			books.setName(request.getParameter("name"));
			books.setDis(request.getParameter("dis"));
			books.setTelephone(request.getParameter("telephone"));
			books.setIdnumber(request.getParameter("idnumber"));
			books.setGender(request.getParameter("gender"));
			books.setAddress(request.getParameter("address"));
			books.setEmailAddress(request.getParameter("emailAddress"));
			VisitorsDaoImp book=new VisitorsDaoImp();
		    book.savevisitor(books);
		    
//		    try {
//		    conn=ConnectionJDBCFactory.getInstance().getConnection();
//		    String sql="select  NAME, DISCRIPTION, TELEPHONE, IDNUMBER, GENDER, ADDRESS, EMAILADDRESS, TIME from visitors where NAME=? and DISCRIPTION=? ";
//			pstmt=conn.prepareStatement(sql);
//			ResultSet rs=pstmt.executeQuery();
//			if(rs.next()){
//				 out.println("Your record is saved in the database....");
//			}else {
//				out.println("THE  RECORD  YOURE TRYING TO  SUBMIT DO EXIST  IN THE DATABASE PLEASE TRY A NEW REGISTRATION.....");
//				
//			}   
//			} catch (Exception e) {
//				System.out.println("Error:" + e.getMessage());
//				
//			}
			 if(book.equals("")){
				 out.println("Your record is not saved in the database....");	
			}else {
				 out.println("Your record is saved in the database....");
			}
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
}
