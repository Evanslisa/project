/**
 * 
 */
package com.Visitorswebsite.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import utils.database.ConnectionJDBCFactory;

import com.Visitorswebsite.dao.AdminstratorDao;
import com.Visitorswebsite.model.Adminstrator;

/**
 * @author lisa
 *
 */
public class AdminstratorDaolmp implements AdminstratorDao {

	@Override
	public Adminstrator saveadmin(Adminstrator admins) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int inserted=0;
		Adminstrator admins_=null;
		try {
			String sql="insert into adminstrator  values(null,?,?,?,?,?,?)";
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, admins.getUsername());	
			pstmt.setString(2,admins.getPassword());
			pstmt.setString(3, admins.getRepassword());
			pstmt.setString(4, admins.getPhone());
			pstmt.setString(5, admins.getAddress());
			pstmt.setTimestamp(6, new java.sql.Timestamp(admins.getDates().getTime()));
		    inserted=pstmt.executeUpdate();
		    if(inserted>0){
				
					return admins_;
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins_;
	}

	@Override
	public void deleteAdmin(Adminstrator admins) {
		// TODO Auto-generated method stub
		
	}

	

}
