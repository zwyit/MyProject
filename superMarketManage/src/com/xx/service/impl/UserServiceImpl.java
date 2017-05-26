package com.xx.service.impl;

import java.util.List;

import com.xx.dao.UserDAO;
import com.xx.entity.Users;
import com.xx.service.UserService;
import com.xx.util.DAOFactory;
import com.xx.util.JdbcUtil;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO=DAOFactory.getUserDAO();
	@Override
	public void save(Users users) {
		try{
			userDAO.save(users);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void delete(Users users) {
		try{
			userDAO.delete(users);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void update(Users users) {
		try{
			userDAO.update(users);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public List<Users> selectAll() {
		try{
			return userDAO.selectAll();
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public Users selectOne(Integer u_id) {
		try{
			return userDAO.selectOne(u_id);
		}finally{
			JdbcUtil.close();
		}
	}

}
