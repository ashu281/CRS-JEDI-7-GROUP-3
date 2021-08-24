package com.flipkart.bean;

import java.util.Date;

/**
 *
 * @author JEDI-07
 * Admin Class
 *
 */

public class Admin extends User{
	private String adminID;

	public Admin(String userId, String name, String gender, String password,String address, String adminId,String role) {
		super(userId, name, gender, password, address,role);
		this.adminID = adminId;
	}

	/**
	 * Method to get Admin ID
	 * @return Admin ID
	 */

	public String getAdminID() {
		return adminID;
	}

	/**
	 * Method to set Admin ID
	 * @param Admin ID
	 */

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	 
	 
	 
	 
	 
}
