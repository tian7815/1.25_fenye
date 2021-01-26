package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.entity.User;



public class UserdaoImpl implements Userdao {
	public static final String URL = "jdbc:mysql://localhost:3306/mydb?characterEncoding=utf-8";
	public static final String USER = "root";
	public static final String PWD = "123456";
	
	public User quaryUserByuid(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		String sql = "select * from user where uid = ?";	
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		User user = new User();
		rs.next();
		String uid1 = rs.getString(1);
		String uname1 = rs.getString(2);
		int uage1 = rs.getInt(3);
		String uphone1 = rs.getString(4);
		String ugender1 = rs.getString(5);
		user.setUid(uid1);
		user.setUname(uname1);
		user.setUage(uage1);
		user.setUgender(ugender1);
		user.setUphone(uphone1);
		
		
		return user;
	}

	public String stuLogin(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		String sql = " select uname from user where uid = ? ";	
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		String pwd = "";
		while(rs.next()){
			pwd = rs.getString("uname");
		}
		return pwd;
	}

	public List<User> selectPage(int offset, int len) throws Exception {
		List<User> userList = new ArrayList<User>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		String sql = " select * from user limit ?, ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, offset);
		preparedStatement.setInt(2, len);
		ResultSet executeQuery = preparedStatement.executeQuery();
		while(executeQuery.next()){
			User user = new User();
			String uid = executeQuery.getString("uid");
			String uname = executeQuery.getString("uname");
			int uage = executeQuery.getInt("uage");
			String uphone = executeQuery.getString("uphone");
			String ugender = executeQuery.getString("ugender");
			user.setUid(uid);
			user.setUname(uname);
			user.setUage(uage);
			user.setUphone(uphone);
			user.setUgender(ugender);
			userList.add(user);
		}
		return userList;
	}

	public int selectCount() throws Exception {
		List<User> userList = new ArrayList<User>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		String sql = " select * from user ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet executeQuery = preparedStatement.executeQuery();
		while(executeQuery.next()){
			User user = new User();
			String uid = executeQuery.getString("uid");
			String uname = executeQuery.getString("uname");
			int uage = executeQuery.getInt("uage");
			String uphone = executeQuery.getString("uphone");
			String ugender = executeQuery.getString("ugender");
			user.setUid(uid);
			user.setUname(uname);
			user.setUage(uage);
			user.setUphone(uphone);
			user.setUgender(ugender);
			userList.add(user);
		}
		int count = userList.size();
		return count;
	}

}