package com.xingxue.www.service.imp;

import java.util.List;

import com.xingxue.www.dao.CartDAO;
import com.xingxue.www.dao.OrderDAO;
import com.xingxue.www.dao.OrderDetailDAO;
import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.entity.Order;
import com.xingxue.www.entity.OrderDetail;
import com.xingxue.www.entity.Product;
import com.xingxue.www.entity.User;
import com.xingxue.www.service.OrderService;
import com.xingxue.www.util.DAOFactory;
import com.xingxue.www.util.JdbcUtilC3P0;

public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDAO = DAOFactory.getOrderDAO();
	private OrderDetailDAO orderDetailDAO = DAOFactory.getOrderDetailDAO();
	private CartDAO cartDAO=DAOFactory.getCartDao();
	private ProductDAO productDAO=DAOFactory.getProductDAO();
	//�µ�
	@Override
	public void order(Order order, List<OrderDetail> details) {
		try{
			JdbcUtilC3P0.begin();//�ֶ���ʼ����
			orderDAO.insert(order);
			int id=order.getId();
			for (OrderDetail d : details) {
				// ��ö�������������Ϊ������������
				d.setOrder_id(id);
				//��д������ϸ
				orderDetailDAO.insert(d);
			}
			//��չ��ﳵ
			cartDAO.clear(order.getUser_id());
			//������
			for(OrderDetail d:details){
				int p_id=d.getP_id();
				Product product=productDAO.selectOne(p_id);
				int num=product.getCount()-d.getP_num();
				product.setCount(num);
				productDAO.update(product);
			}
			//��ȡ
			JdbcUtilC3P0.commit();
		}catch(Exception e){
			JdbcUtilC3P0.rollback();
		}finally{
			JdbcUtilC3P0.close();
		}
		
	}

	@Override
	public void insert(Order order) {
		try{
			orderDAO.insert(order);
		}finally{
			JdbcUtilC3P0.close();
		}
	}

	@Override
	public List<Order> selectAll(User user) {
		try{
			return orderDAO.selectAll(user);
		}finally{
			JdbcUtilC3P0.close();
		}
	}

	@Override
	public Order selectOne(int id) {
		try{
			return orderDAO.selectOne(id);
		}finally{
			JdbcUtilC3P0.close();
		}
	}

}
