package com.xx.dao;

import java.util.List;

import com.xx.entity.Bill;

public interface BillDAO {
	public void save(Bill bill);
	public void delete(Bill bill);
	public void update(Bill bill);
	public List<Bill> selectAll();
	public Bill selectOne(Integer id);
	
	/**
	 * @param page“≥∫≈
	 * @param rows“≥√Ê¥Û–°
	 */
	public List<Bill> selectBillForPage(int page,int rows);
}
