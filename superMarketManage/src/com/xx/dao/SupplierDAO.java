package com.xx.dao;

import java.util.List;

import com.xx.entity.Bill;
import com.xx.entity.Supplier;

public interface SupplierDAO {
	public void save(Supplier supplier);
	public void delete(Supplier supplier);
	public void update(Supplier supplier);
	public List<Supplier> selectAll();
	public Supplier selectOne(Integer id);
	
	/**
	 * @param page“≥∫≈
	 * @param rows“≥√Ê¥Û–°
	 */
	public List<Supplier> selectSupplierForPage(int page,int rows);
}
