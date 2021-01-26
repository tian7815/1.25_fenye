package com.company.test;

import java.util.List;

import com.company.dao.Userdao;
import com.company.dao.UserdaoImpl;
import com.company.entity.User;

public class TestClass {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Userdao userdaoImpl = new UserdaoImpl();
		List<User> list = userdaoImpl.selectPage(0, 5);
		for(User user: list){
			System.out.println(user);
		}
	}

}
