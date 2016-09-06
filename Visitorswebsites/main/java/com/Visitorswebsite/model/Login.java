/**
 * 
 */
package com.Visitorswebsite.model;

/**
 * @author lisa
 *
 */
public class Login {
	private String username,password;
	 public boolean valid;
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
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
