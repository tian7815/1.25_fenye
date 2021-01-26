package com.company.service;

import java.util.List;

import com.company.dao.Userdao;
import com.company.dao.UserdaoImpl;
import com.company.entity.User;

public class UserServiceImpl implements UserService {
    private Userdao userdao = new UserdaoImpl();
	public User quaryUserByuid(String uid) throws Exception {
		userdao = new UserdaoImpl();
		User quaryUserByuid = userdao.quaryUserByuid(uid);
		return quaryUserByuid;
	}

	public String stuLogin(String uid) throws Exception {
		userdao = new UserdaoImpl();
		String pwd = userdao.stuLogin(uid);
		return pwd;
	}

	public List<User> queryUserByFenYe(int offset, int len) throws Exception {
	    List<User> userList = userdao.selectPage(offset, len);
		return userList;
	}

	public int queryRows() throws Exception {
		int rows = userdao.selectCount();
		return rows;
	}

}
