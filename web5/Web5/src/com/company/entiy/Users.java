package com.company.entiy;

public class Users {
   private String sid;
   private int sage;
   private String saddress;
   private String sname;
   private String simage;
   
   public String getSimage() {
	return simage;
}
public void setSimage(String simage) {
	this.simage = simage;
}
public String getSid() {
	return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Users [saddress=" + saddress + ", sage=" + sage + ", sid="
				+ sid + ", sname=" + sname + "]";
	}
 
}