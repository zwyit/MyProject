package com.xingxue.www.util;

import com.xingxue.www.dao.BrandDAO;
import com.xingxue.www.dao.CategoryDAO;
import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.dao.UserDAO;
import com.xingxue.www.dao.imp.BrandDAOImpl;
import com.xingxue.www.dao.imp.CategoryDAOImpl;
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
	
}
