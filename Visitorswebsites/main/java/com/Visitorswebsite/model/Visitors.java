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
public class Visitors {
	
	private String  name ;
	private String  telephone;
	private String  idnumber;
	private String  gender;
	private String  address;
	private String  emailAddress;
	@SuppressWarnings("unused")
	private Date dates;
	private String  dis;
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public Date getDates() {
		return dates=Calendar.getInstance().getTime();
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
