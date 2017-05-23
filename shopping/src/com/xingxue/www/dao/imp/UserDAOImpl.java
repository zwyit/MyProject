package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.UserDAO;
import com.xingxue.www.entity.User;
import com.xingxue.www.util.JdbcUtil;

public class UserDAOImpl implements UserDAO {
	
	@Override
	public void save(User user) {
		JdbcUtil.update("insert into t_shop_user values(t_shop_user_seq.nextval,?,?,?,?,?,?,?)", user.getUser_name(),user.getUser_password(),user.getUser_email(),user.getUser_joined(),user.getUser_points(),user.getUser_right(),user.getUser_remark());
	}

	@Override
	public void delete(User user) {
		JdbcUtil.update("delete from t_shop_user where id=?", user.getId());
	}

	@Override
	public void update(User user) {
		JdbcUtil.update("update t_shop_user set user_name=?,user_password?,user_email=?,user_joined=?,user_points=?,user_right=?,user_remark=?", user.getUser_name(),user.getUser_password(),user.getUser_email(),user.getUser_joined(),user.getUser_points(),user.getUser_right(),user.getUser_remark());
	}

	@Override
	public List<User> selectAll() {
		return JdbcUtil.findList(User.class, "select * from t_shop_user");
	}
	 /*public static void main(String[] args) {
		List<User> users=JdbcUtil.findList(User.class, "select * from t_shop_user");
		for(User u:users){
			System.out.println(u);
		}
	}*/

	@Override
	public User selectOne(String name) {
		return JdbcUtil.findOne(User.class, "select * from t_shop_user where user_name=?", name);
	}
}
