/**
 * 
 */
package com.Visitorswebsite.model;

import java.util.Calendar;
import java.util.Date;

/**
 * @author lisa
 *
 */
public class Adminstrator {
	private String  username ;
	private String password;
	private String  repassword;
	private String  phone;
	private String  address;
	@SuppressWarnings("unused")
	private Date dates;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDates() {
		return dates=Calendar.getInstance().getTime();
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}

}
