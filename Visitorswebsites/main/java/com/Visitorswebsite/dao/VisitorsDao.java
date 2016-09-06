/**
 * 
 */
package com.Visitorswebsite.dao;

import java.util.List;

import com.Visitorswebsite.model.Visitors;
import com.sun.org.apache.bcel.internal.classfile.Visitor;



/**
 * @author lisa
 *
 */
public interface VisitorsDao {
	public Visitor savevisitor(Visitors books);
	public Visitors getAllVisitor(Visitors books);
	public List<Visitor> getAllVisitorByNameAndByEmail(String name,String email);
	public void deleteVisitors(Visitor books);
}
