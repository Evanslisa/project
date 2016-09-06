/**
 * 
 */
package com.Visitorswebsite.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.database.ConnectionJDBCFactory;

import com.Visitorswebsite.dao.VisitorsDao;
import com.Visitorswebsite.model.Visitors;
import com.sun.org.apache.bcel.internal.classfile.Visitor;



/**
 * @author lisa
 *
 */
public class VisitorsDaoImp  implements VisitorsDao{

	@Override
	public Visitor savevisitor(Visitors books) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int inserted=0;
		Visitor books_=null;
		try {
			String sql="insert into visitors  values(null,?,?,?,?,?,?,?,?)";
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, books.getName());
			pstmt.setString(2, books.getDis());
		    pstmt.setString(3, books.getTelephone());
		    pstmt.setString(4, books.getIdnumber());
		    pstmt.setString(5, books.getGender());
		    pstmt.setString(6, books.getAddress());
		    pstmt.setString(7, books.getEmailAddress());
		    pstmt.setTimestamp(8, new java.sql.Timestamp(books.getDates().getTime()));
		    inserted=pstmt.executeUpdate();
			if(inserted>0){
			//	books_=  (Visitor) books;
				return books_;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books_;
	}

	@Override
	public Visitors getAllVisitor(Visitors books) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
				String sql="select * from visitors";
				conn=ConnectionJDBCFactory.getInstance().getConnection();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					books=new Visitors();
					books.setName(rs.getString("name"));
					books.setDis(rs.getString("dis"));
					books.setTelephone(rs.getString("telephone"));
				    books.setIdnumber(rs.getString("idnumber"));
				    books.setGender(rs.getString("gender"));
				    books.setAddress(rs.getString("address"));
				    books.setEmailAddress(rs.getString("emailAddress"));
				}
		} catch (Exception e) {
			
		}
		
		return books;
	}

	@Override
	public List<Visitor> getAllVisitorByNameAndByEmail(String name, String email) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Visitor> books_=new ArrayList<Visitor>(0);
		   try {
			   String sql="select * from visitors where name=? and  email=? order by name asc";
				conn=ConnectionJDBCFactory.getInstance().getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				rs=pstmt.executeQuery(); 
				while(rs.next()){
					Visitors books=new Visitors();
					books.setName(rs.getString("name"));
					books.setDis(rs.getString("dis"));
					books.setTelephone(rs.getString("telephone"));
				    books.setIdnumber(rs.getString("idnumber"));
				    books.setGender(rs.getString("gender"));
				    books.setAddress(rs.getString("address"));
				    books.setEmailAddress(rs.getString("emailAddress"));
					books_.add((Visitor) books);	
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books_;
	}

	@Override
	public void deleteVisitors(Visitor books) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			String sql="delete from visitors where idnumber=?";
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ((Visitors) books).getIdnumber());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
