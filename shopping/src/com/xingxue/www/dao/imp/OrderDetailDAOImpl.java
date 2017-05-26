package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.OrderDetailDAO;
import com.xingxue.www.entity.OrderDetail;
import com.xingxue.www.util.JdbcUtilC3P0;

public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Override
	public void insert(OrderDetail orderDetail) {
		String sql = "insert into t_order_detail values(?,?,?,?,?)";
		JdbcUtilC3P0.update(sql,orderDetail.getOrder_id(),orderDetail.getP_id(),orderDetail.getP_name(),orderDetail.getP_price(),orderDetail.getP_num());
	}

	@Override
	public List<OrderDetail> selectDetails(int id) {
		String sql="select * from t_order_detail where order_id=?";
		return JdbcUtilC3P0.findList(OrderDetail.class, sql, id);
	}

}
