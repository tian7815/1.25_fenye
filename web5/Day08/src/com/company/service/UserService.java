package com.company.service;

import java.util.List;

import com.company.entity.User;

public interface UserService {
  public User quaryUserByuid(String uid)throws Exception;
  public String stuLogin (String uid)throws Exception;
  public List<User> queryUserByFenYe(int offset, int len) throws Exception;
  public int queryRows() throws Exception;
}
