package com.xingxue.www.service.imp;

import java.util.List;

import com.xingxue.www.dao.BrandDAO;
import com.xingxue.www.entity.Brand;
import com.xingxue.www.service.BrandService;
import com.xingxue.www.util.DAOFactory;
import com.xingxue.www.util.JdbcUtil;

public class BrandServiceImpl implements BrandService {
	private BrandDAO brandDAO=DAOFactory.getBrandDAO();
	@Override
	public void save(Brand brand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Brand brand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Brand brand) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Brand> selectAll() {
		try{
			return brandDAO.selectAll();
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public Brand selectOne(Integer id) {
		try{
			return brandDAO.selectOne(id);
		}finally{
			JdbcUtil.close();
		}
	}

}
