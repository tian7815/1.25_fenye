package com.company.entity;

public class User {
	
	private String uid;
	private String upass;
	private String uname;
	private String uage;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUage() {
		return uage;
	}
	public void setUage(String uage) {
		this.uage = uage;
	}
	@Override
	public String toString() {
		return "user [uage=" + uage + ", uid=" + uid + ", uname=" + uname
				+ ", upass=" + upass + "]";
	}
	public User() {
	}
	public User(String uid, String upass, String uname, String uage) {
		this.uid = uid;
		this.upass = upass;
		this.uname = uname;
		this.uage = uage;
	}
}