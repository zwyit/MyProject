package com.xingxue.www.service;

import java.util.List;

import com.xingxue.www.dao.OrderDetailDAO;
import com.xingxue.www.dao.OrderDetailService;
import com.xingxue.www.entity.OrderDetail;
import com.xingxue.www.util.DAOFactory;
import com.xingxue.www.util.JdbcUtilC3P0;

public class OrderDetailServiceImpl implements OrderDetailService {
	private OrderDetailDAO orderDetailDAO=DAOFactory.getOrderDetailDAO();
	@Override
	public List<OrderDetail> selectDetails(int id) {
		try{
			return orderDetailDAO.selectDetails(id);
		}finally{
			JdbcUtilC3P0.close();
		}
	}

}
