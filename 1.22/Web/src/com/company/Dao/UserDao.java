package com.company.Dao;

import java.sql.Connection;


public interface UserDao {
	//ͨ����ɾ��
	public int generalCUD(String sql, Object...args)throws Exception;
	//ͨ�ò�
	public boolean generalR(Connection conn, String sql, String user)throws Exception;


}
