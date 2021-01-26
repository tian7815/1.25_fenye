package com.company.dao;

import java.util.List;

import com.company.entity.User;

public interface Userdao {
	public User quaryUserByuid(String uid)throws Exception;
	public String stuLogin (String uid)throws Exception;

	public List<User> selectPage(int offset, int len) throws Exception;
	public int selectCount() throws Exception;
}
