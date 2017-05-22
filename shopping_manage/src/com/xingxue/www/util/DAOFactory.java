package com.xingxue.www.util;

import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.dao.UserDAO;
import com.xingxue.www.dao.imp.ProductDAOImpl;
import com.xingxue.www.dao.imp.UserDAOImpl;

public class DAOFactory {
	public static ProductDAO getProductDAO(){
		return new ProductDAOImpl();
	}
	
	public static UserDAO getUserDAO(){
		return  new UserDAOImpl();
	}
}
