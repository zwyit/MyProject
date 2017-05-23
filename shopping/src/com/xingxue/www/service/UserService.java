package com.xingxue.www.service;

import java.util.List;

import com.xingxue.www.entity.User;

public interface UserService {
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	public User selectOne(String name);
	public List<User> selectAll();
}
