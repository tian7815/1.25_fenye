package com.company.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.Dao.UsersDao;
import com.company.entiy.Users;

public class UsersDaoIpml implements UsersDao {
	public static final String URL = "jdbc:mysql://localhost:3306/mydb?characterEncoding=utf-8";
	public static final String USER = "root";
	public static final String PWD = "123456";
	public String delete(Users users) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		String sql = "select sid from student where sid = ?";
		CallableStatement pc = connection.prepareCall(sql);
		pc.setString(1, users.getSid());
		ResultSet rs = pc.executeQuery();
		Users user = new Users();
		while (rs.next()) {
			String sid = rs.getString("sid");
			user.setSid(sid);
		}
	
		if (user.getSid()!=null) {
			System.out.println("hh");
			String sql1 = "delete from student where sid = ?";
			CallableStatement pc1 = connection.prepareCall(sql1);
			pc1.setString(1, user.getSid());
			pc1.execute();
		}else{
			System.out.println("asd");
		}
		return user.getSid();
	}
	public static void main(String[] args) throws Exception {
		UsersDao d =new UsersDaoIpml();
		d.delete(new Users());
	}
	public Users select(String sid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		String sql = "select * from student where sid = ?";
		CallableStatement pc = connection.prepareCall(sql);
		pc.setString(1, sid);
		ResultSet rs = pc.executeQuery();
		Users user = new Users();
		while (rs.next()) {
			String id = rs.getString("sid");
			String sname = rs.getString("sname");
			int sage = rs.getInt("sage");
			String saddress = rs.getString("saddress");
			user.setSid(id);
			user.setSname(sname);
			user.setSage(sage);
			user.setSaddress(saddress);
		}	
		
		return user;
	}
	public List<Users> selectAll() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		String sql = " select * from student ";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ResultSet rs = prepareStatement.executeQuery();
        List<Users> userList = new ArrayList<Users>();
        while(rs.next()){
        	Users user = new Users();
        	String sid = rs.getString("sid");
        	String sname = rs.getString("sname");
        	int sage = Integer.valueOf(rs.getString("sage"));
        	String saddress = rs.getString("saddress");
        	String simage = rs.getString("simage");
        	user.setSid(sid);
        	user.setSname(sname);
        	user.setSage(sage);
        	user.setSaddress(saddress);
        	user.setSimage(simage);
        	userList.add(user);
        }
		return userList;
	}
  
}
