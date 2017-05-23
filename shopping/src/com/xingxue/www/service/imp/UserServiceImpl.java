package com.xingxue.www.service.imp;

import java.util.List;

import com.xingxue.www.dao.UserDAO;
import com.xingxue.www.entity.User;
import com.xingxue.www.service.UserService;
import com.xingxue.www.util.DAOFactory;
import com.xingxue.www.util.JdbcUtil;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO=DAOFactory.getUserDAO();
	@Override
	public void save(User user) {
		try{
			userDAO.save(user);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void delete(User user) {
		try{
			userDAO.delete(user);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void update(User user) {
		try{
			userDAO.update(user);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public List<User> selectAll() {
		try{
			return userDAO.selectAll();
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public User selectOne(String name) {
		try{
			return userDAO.selectOne(name);
		}finally{
			JdbcUtil.close();
		}
	}

}
