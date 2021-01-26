package com.company.Dao;

import java.util.List;

import com.company.entiy.Users;

public interface UsersDao {
    public String delete(Users users)throws Exception;
    public Users select(String sid)throws Exception;
    public List<Users> selectAll() throws Exception;
}
