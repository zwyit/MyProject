package com.xx.dao.impl;

import java.util.List;

import com.xx.dao.BillDAO;
import com.xx.entity.Bill;
import com.xx.util.JdbcUtil;

public class BillDAOImpl implements BillDAO {

	@Override
	public void save(Bill bill) {
//		JdbcUtil.update("insert into t_bill values(t_bill_seq.nextval,?,?,?,?)", bill.getCode(),bill.getMoney(),bill.getPayStatus(),bill.getProductDesc());
		JdbcUtil.update("insert into t_bill values(t_bill_seq.nextval,?,?,?,?,?,?,?,?)", bill.getCode(),bill.getProductName(),bill.getProductCount(),bill.getMoney(),bill.getPayStatus(),bill.getSupplierName(),bill.getProductDesc(),bill.getCreateDate());
	}

	@Override
	public void delete(Bill bill) {
		JdbcUtil.update("delete  from t_bill where id=?", bill.getId());
	}

	@Override
	public void update(Bill bill) {
		JdbcUtil.update("update t_bill set code=?,money=?,productDesc=?,payStatus=? where id=?", bill.getCode(),bill.getMoney(),bill.getProductDesc(),bill.getPayStatus(),bill.getId());
	}

	@Override
	public List<Bill> selectAll() {
		return JdbcUtil.findList(Bill.class, "select * from t_bill");
	}

	@Override
	public Bill selectOne(Integer id) {
		return JdbcUtil.findOne(Bill.class, "select * from t_bill where id=?", id);
	}

	@Override
	public List<Bill> selectBillForPage(int page, int rows) {
		return JdbcUtil.findList(Bill.class, page, rows, "select * from t_bill");
	}

}
