package com.company.entity;

public class User {
	private String uid;
	 private String uname;
	 private int uage;
	 private String uphone;
	 private String ugender;
	 
 public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

@Override
	public String toString() {
		return "User [uage=" + uage + ", ugender=" + ugender + ", uid=" + uid
				+ ", uname=" + uname + ", uphone=" + uphone + "]";
	}

}
