package com.company.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.entity.User;
/**
 * ���ù�����
 * @author admin
 *
 */
public class Utility {
	private static final String url="jdbc:mysql://localhost:3306/hts";
	private static final String user="root";
	private static final String password="123456";
	private static final String driver="com.mysql.jdbc.Driver";
	/**���������ݿ������*/
	public static Connection connMysql()throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	/**�Ͽ�����*/
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**ͨ����ɾ��*/
	public static int generalCUD(String sql, Object... args) throws Exception {
		Connection conn = Utility.connMysql();
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		for(int i = 0; i < args.length; i++){
			prepareStatement.setObject(i+1, args[i]);
		}
		int executeUpdate = prepareStatement.executeUpdate();
		conn.close();
		return executeUpdate;
	}
	/**
	 * ����ȥһ��Conn�����һ��SQL��仹��ռλ��
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static int executeObject(Connection conn, String sql,Object...args)throws Exception{
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		for( int i = 0; i < args.length; i++){
			prepareStatement.setObject(i+1, args[i]);
		}
		int executeUpdate = prepareStatement.executeUpdate();
		close(conn);
		return executeUpdate;
	}
	//ͨ�ò�ѯ����
	/**
	 * List<User> userList
	 */
//	public static User generalR(String uid) throws Exception {
//		Connection conn = Utility.connMysql();
//		String sql = " select * from user where uid = ? ";
//		PreparedStatement prepareStatement = conn.prepareStatement(sql);
////		PreparedStatement prepareStatement = connection.prepareStatement(sql);
//		prepareStatement.setString(1, uid);
//		ResultSet rs = prepareStatement.executeQuery();
//		User user = new User();
//		while(rs.next()){
//			String uid1 = rs.getString("uid");
//			String upass1 = rs.getString("pass");
//			String uname1 = rs.getString("name");
//			String uage1 = rs.getString("age");
//			user.setUid(uid1);
//			user.setUpass(upass1);
//			user.setUname(uname1);
//			user.setUage(uage1);
//		}
//		return user;
//	}
	
}