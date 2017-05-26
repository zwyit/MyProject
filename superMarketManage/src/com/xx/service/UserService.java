package com.xx.service;

import java.util.List;

import com.xx.entity.Users;

public interface UserService {
	public void save(Users users);
	public void delete(Users users);
	public void update(Users users);
	public List<Users> selectAll();
	public Users selectOne(Integer u_id);
}
