package com.xx.service;

import java.util.List;

import com.xx.entity.Bill;
import com.xx.entity.Supplier;

public interface SupplierService {
	public void save(Supplier supplier);
	public void delete(Supplier supplier);
	public void update(Supplier supplier);
	public List<Supplier> selectAll();
	public Supplier selectOne(Integer id);
	
	//·ÖÒ³
	public List<Supplier> selectSupplierForPage(int page,int rows);
}
