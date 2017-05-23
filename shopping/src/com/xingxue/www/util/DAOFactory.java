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
	//用户
	public static UserDAO getUserDAO(){
		return new UserDAOImpl();
	}
	//商品
	public static ProductDAO getProductDAO(){
		return new ProductDAOImpl();
	}
	//品牌
	public static BrandDAO getBrandDAO(){
		return new BrandDAOImpl();
	}
	//类别
	public static CategoryDAO getCategoryDAO(){
		return new CategoryDAOImpl();
	}
	
}
