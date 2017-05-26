package com.xx.util;

import com.xx.dao.BillDAO;
import com.xx.dao.SupplierDAO;
import com.xx.dao.UserDAO;
import com.xx.dao.impl.BillDAOImpl;
import com.xx.dao.impl.SupplierDAOImpl;
import com.xx.dao.impl.UserDAOImpl;

public class DAOFactory {
	
	  public static BillDAO getBillDAO(){
		  return new BillDAOImpl();
	  }
	  
	  public static SupplierDAO getSupplierDAO(){
		  return new SupplierDAOImpl();
	  }
	  
	  public static UserDAO getUserDAO(){
		  return new UserDAOImpl();
	  }
}
