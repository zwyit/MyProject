package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.BrandDAO;
import com.xingxue.www.entity.Brand;
import com.xingxue.www.util.JdbcUtil;

public class BrandDAOImpl implements BrandDAO {

	@Override
	public void save(Brand brand) {
		JdbcUtil.update("insert into t_brand id=t_brand_seq.nextval,name=?,code=?,remark=?", brand.getName(),brand.getCode(),brand.getRemark());
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
		return JdbcUtil.findList(Brand.class, "select * from t_brand");
	}

	@Override
	public Brand selectOne(Integer id) {
		return JdbcUtil.findOne(Brand.class, "select * from t_brand where id=?", id);
	}

}
