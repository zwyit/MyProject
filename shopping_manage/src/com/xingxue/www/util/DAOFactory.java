package com.xingxue.www.util;

import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.dao.imp.ProductDAOImpl;

public class DAOFactory {
	public static ProductDAO getProductDAO(){
		return new ProductDAOImpl();
	}
	
}
