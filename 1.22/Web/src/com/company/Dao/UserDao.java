package com.company.Dao;

import java.sql.Connection;


public interface UserDao {
	//通用增删改
	public int generalCUD(String sql, Object...args)throws Exception;
	//通用查
	public boolean generalR(Connection conn, String sql, String user)throws Exception;


}
