package com.xx.dao.impl;

import java.util.List;

import com.xx.dao.UserDAO;
import com.xx.entity.Users;
import com.xx.util.JdbcUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public void save(Users users) {
		JdbcUtil.update("insert into t_uesr2 values(t_user2_seq.nextval,?,?,?,?,?,?,?,?)", users.getUserCode(),users.getUserName(),users.getUserPassword(),users.getUserSex(),users.getUserAge(),users.getUserTel(),users.getUserAddr(),users.getUserRight());
	}

	@Override
	public void delete(Users users) {
		JdbcUtil.update("delete from t_uesr2 where u_id=?", users.getU_id());
	}

	@Override
	public void update(Users users) {
		JdbcUtil.update("update t_uesr2 set userName=?,userPassword=?,userTel=?,userAddr=?,userRight=? where u_id=?", users.getUserName(),users.getUserPassword(),users.getUserTel(),users.getUserAddr(),users.getUserRight(),users.getU_id());
	}

	@Override
	public List<Users> selectAll() {
		
		return JdbcUtil.findList(Users.class, "select * from t_uesr2");
	}

	@Override
	public Users selectOne(Integer u_id) {
		return JdbcUtil.findOne(Users.class, "select * from t_uesr2 where u_id=?",u_id);
	}

}
