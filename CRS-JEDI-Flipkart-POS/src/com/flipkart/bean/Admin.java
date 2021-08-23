package com.flipkart.bean;

import java.util.Date;

public class Admin extends User{
	 private String adminID;
	 private Date date;
	 
	 
	 public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	 
	 
	 
	 
	 
}
