package com.Visitorswebsite.Listener;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.database.ConnectionJDBCFactory;


@WebListener
public class VisitorsListener implements ServletContextListener {
	static Connection conn;
	static PreparedStatement pstmt;
	int status = 0;


    public VisitorsListener() {
    	conn = null;
		pstmt = null;
        
    }
    public void contextInitialized(ServletContextEvent arg0) {
    	try {
    		if (status==0){
        	  System.out.println("Your Visitors table already exist " + status);
        	  System.out.println("Your Adminstrator table  already exist " + status);
        	  }else if (status==2){
       		  System.out.println("else if table does not exist create new table  " + status);
        		}
    		conn=ConnectionJDBCFactory.getInstance().getConnection();
    		String query = "create table  visitors (ID int(10) not null auto_increment primary key, NAME VARCHAR(40),DISCRIPTION VARCHAR(40),TELEPHONE VARCHAR(40),IDNUMBER VARCHAR(40),GENDER VARCHAR(40),ADDRESS VARCHAR(40), EMAILADDRESS VARCHAR(40),TIME VARCHAR(40))";
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
    		
			String query1 = "create table  adminstrator (ID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, USERNAME VARCHAR(40),PASSWORD VARCHAR(40),REPASSWORD VARCHAR(40),PHONENUMBER VARCHAR(40),ADDRESS VARCHAR(40),TIME VARCHAR(40))";
			pstmt = conn.prepareStatement(query1);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			
		}
    	
        
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
