/**
 * 
 */
package com.Visitorswebsite.dao;

import com.Visitorswebsite.model.Adminstrator;

/**
 * @author lisa
 *
 */
public interface AdminstratorDao {
	public Adminstrator saveadmin(Adminstrator admins);
	public void deleteAdmin(Adminstrator admins);

}
