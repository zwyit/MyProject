package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.User;

public interface UserDAO {
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	
	public List<User> selectAll();
}
