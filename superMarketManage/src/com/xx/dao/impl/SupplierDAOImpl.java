package com.xx.dao.impl;

import java.util.List;

import com.xx.dao.SupplierDAO;
import com.xx.entity.Bill;
import com.xx.entity.Supplier;
import com.xx.util.JdbcUtil;

public class SupplierDAOImpl implements SupplierDAO {

	@Override
	public void save(Supplier supplier) {
		JdbcUtil.update("insert into t_supplier values(t_supplier_seq.nextval,?,?,?,?,?,?,?)", supplier.getSupplierCode(),supplier.getSupplierName(),supplier.getSupplierDexc(),supplier.getSupplierPerson(),supplier.getSupplierTel(),supplier.getSupplierChuan(),supplier.getSupplierAddr());
	}

	@Override
	public void delete(Supplier supplier) {
		JdbcUtil.update("delete  from t_supplier where s_id=?", supplier.getS_id());

	}

	@Override
	public void update(Supplier supplier) {
		JdbcUtil.update("update t_supplier set supplierCode=?,supplierName=?,supplierDexc=?,supplierPerson=?,supplierTel=?,supplierAddr=? where s_id=? ",supplier.getSupplierCode(),supplier.getSupplierName(),supplier.getSupplierDexc(),supplier.getSupplierPerson(),supplier.getSupplierTel(),supplier.getSupplierAddr(),supplier.getS_id());
	}

	@Override
	public List<Supplier> selectAll() {
		return JdbcUtil.findList(Supplier.class,"select * from t_supplier");
	}

	@Override
	public Supplier selectOne(Integer id) {
		return JdbcUtil.findOne(Supplier.class, "select * from t_supplier where s_id=?", id);
	}
	//·ÖÒ³
	@Override
	public List<Supplier> selectSupplierForPage(int page, int rows) {
		return JdbcUtil.findList(Supplier.class, page, rows,"select * from t_supplier" );
	}

}
