package com.xx.service.impl;

import java.util.List;

import com.xx.dao.BillDAO;
import com.xx.dao.SupplierDAO;
import com.xx.entity.Supplier;
import com.xx.service.SupplierService;
import com.xx.util.DAOFactory;
import com.xx.util.JdbcUtil;

public class SupplierServiceImpl implements SupplierService {
	private  SupplierDAO supplierDAO = DAOFactory.getSupplierDAO();
	
	@Override
	public void save(Supplier supplier) {
		try{
			supplierDAO.save(supplier);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void delete(Supplier supplier) {
		try{
			supplierDAO.delete(supplier);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void update(Supplier supplier) {
		try{
			supplierDAO.update(supplier);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public List<Supplier> selectAll() {
		try{
			return supplierDAO.selectAll();
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public Supplier selectOne(Integer id) {
		try{
			return supplierDAO.selectOne(id);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public List<Supplier> selectSupplierForPage(int page, int rows) {
		try{
			return supplierDAO.selectSupplierForPage(page, rows);
		}finally{
			JdbcUtil.close();
		}
	}
}
