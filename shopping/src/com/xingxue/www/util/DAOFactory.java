package com.xingxue.www.util;

import com.xingxue.www.dao.BrandDAO;
import com.xingxue.www.dao.CartDAO;
import com.xingxue.www.dao.CategoryDAO;
import com.xingxue.www.dao.OrderDAO;
import com.xingxue.www.dao.OrderDetailDAO;
import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.dao.UserDAO;
import com.xingxue.www.dao.imp.BrandDAOImpl;
import com.xingxue.www.dao.imp.CartDAOImpl;
import com.xingxue.www.dao.imp.CategoryDAOImpl;
import com.xingxue.www.dao.imp.OrderDAOImpl;
import com.xingxue.www.dao.imp.OrderDetailDAOImpl;
import com.xingxue.www.dao.imp.ProductDAOImpl;
import com.xingxue.www.dao.imp.UserDAOImpl;

public class DAOFactory {
	//�û�
	public static UserDAO getUserDAO(){
		return new UserDAOImpl();
	}
	//��Ʒ
	public static ProductDAO getProductDAO(){
		return new ProductDAOImpl();
	}
	//Ʒ��
	public static BrandDAO getBrandDAO(){
		return new BrandDAOImpl();
	}
	//���
	public static CategoryDAO getCategoryDAO(){
		return new CategoryDAOImpl();
	}
	//���ﳵ
	public static CartDAO getCartDao(){
		return new CartDAOImpl();
	}
	//����
	public static OrderDAO getOrderDAO(){
		return new OrderDAOImpl();
	}
	//��������
	public static OrderDetailDAO getOrderDetailDAO(){
		return new OrderDetailDAOImpl();
	}
}
