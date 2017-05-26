package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.OrderDAO;
import com.xingxue.www.entity.Order;
import com.xingxue.www.entity.User;
import com.xingxue.www.util.JdbcUtilC3P0;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void insert(Order order) {
		String sql = "insert into t_order values(t_order_seq.nextval,?,?,?,?,?)";
		int id = JdbcUtilC3P0.insert(sql, "id", 
				order.getUser_id(), order.getAddr_id(), order.getTotal(), order.getOrder_date(), order.getStatus());
		order.setId(id);
	}

	@Override
	public List<Order> selectAll(User user) {
		return JdbcUtilC3P0.findList(Order.class, "select * from t_order where user_id=?", user.getId());
	}

	@Override
	public Order selectOne(int id) {
		return JdbcUtilC3P0.findOne(Order.class, "select * from t_order where id=?", id);
	}

}
