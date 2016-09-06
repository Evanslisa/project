/**
 * 
 */
package com.Visitorswebsite.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.database.ConnectionJDBCFactory;

import com.Visitorswebsite.model.Login;

/**
 * @author lisa
 *
 */
public class LoginDaolmp {
	static Connection conn=null;
	static PreparedStatement pstmt=null;
//	private static final String sql = null;
	static int temp=0;
	 public static int insert(String username,String password){
		try {
			conn=ConnectionJDBCFactory.getInstance().getConnection();
//			pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			String sql="insert into adminstrator  values(null,?,?)";
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		pstmt.setString(1, username);
    		pstmt.setString(2, password);
    		temp=pstmt.executeUpdate();		
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return temp;  
	 }
	 public static Login login(Login bean){
		 String username=bean.getUsername();
		  String password=bean.getPassword();
		  System.out.println("your username  is:" + username);
		  System.out.println("Your password  is:" + password);
		 try {
			    conn=ConnectionJDBCFactory.getInstance().getConnection();
//				pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			    String sql="select * from adminstrator  where USERNAME='"+ username+"' and PASSWORD='"+password+"'";
	    		PreparedStatement ps=conn.prepareStatement(sql);
	    		ResultSet rs=ps.executeQuery();
	    		boolean more=rs.next();
	    		if(!more){
	    			System.out.println("Please you must login first with the correct username or password");
	    			System.out.println("your username have error:" + username);
	    			  System.out.println("Your password have error:" + password);
	    			bean.setValid(false);
	    		}else if (more) {
	    		username=rs.getString(2);
	    		password=rs.getString(3);
	    		bean.setUsername(username);
	    		bean.setPassword(password);
	    		bean.setValid(true);
	    		System.out.println("WELCOME TO VISITORS WEBSITE");
	    		System.out.println(sql);
	    				    		
	    		}
			
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return bean;
		 
	 }
}
