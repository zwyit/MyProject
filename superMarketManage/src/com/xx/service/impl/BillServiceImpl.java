package com.xx.service.impl;

import java.util.List;

import com.xx.dao.BillDAO;
import com.xx.entity.Bill;
import com.xx.service.BillService;
import com.xx.util.DAOFactory;
import com.xx.util.JdbcUtil;

public class BillServiceImpl implements BillService {
	
	private  BillDAO billDAO = DAOFactory.getBillDAO();
	@Override
	public void save(Bill bill) {
		try {
			billDAO.save(bill);
		}finally{
			JdbcUtil.close();
		}

	}

	@Override
	public void delete(Bill bill) {
		try{
			billDAO.delete(bill);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void update(Bill bill) {
		try{
			billDAO.update(bill);
		}finally{
			JdbcUtil.close();
		}

	}

	@Override
	public List<Bill> selectAll() {
		try {
			return billDAO.selectAll();
		} finally {
			JdbcUtil.close();
		}
	}

	@Override
	public Bill selectOne(Integer id) {
		try {
			return billDAO.selectOne(id);
		} finally {
			JdbcUtil.close();
		}
	}

	@Override
	public List<Bill> selectBillForPage(int page, int rows) {
		try {
			return billDAO.selectBillForPage(page, rows);
		} finally {
			JdbcUtil.close();
		}
	}

}
