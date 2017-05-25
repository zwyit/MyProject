package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.BrandDAO;
import com.xingxue.www.entity.Brand;
import com.xingxue.www.util.JdbcUtilC3P0;

public class BrandDAOImpl implements BrandDAO {

	@Override
	public void save(Brand brand) {
		JdbcUtilC3P0.update("insert into t_brand id=t_brand_seq.nextval,name=?,code=?,remark=?", brand.getName(),brand.getCode(),brand.getRemark());
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
		return JdbcUtilC3P0.findList(Brand.class, "select * from t_brand");
	}

	@Override
	public Brand selectOne(Integer id) {
		return JdbcUtilC3P0.findOne(Brand.class, "select * from t_brand where id=?", id);
	}

}
