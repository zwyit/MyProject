package com.xx.service;

import java.util.List;

import com.xx.entity.Bill;

public interface BillService {
	public void save(Bill bill);
	public void delete(Bill bill);
	public void update(Bill bill);
	public List<Bill> selectAll();
	public Bill selectOne(Integer id);
	
	public List<Bill> selectBillForPage(int page,int rows);
}
