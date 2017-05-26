package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.CartDAO;
import com.xingxue.www.entity.Cart;
import com.xingxue.www.util.JdbcUtilC3P0;

public class CartDAOImpl implements CartDAO {

	@Override
	public void add(int user_id,int product_id,int num){
		JdbcUtilC3P0.update("insert into t_cart values(t_cart_seq.nextval,?,?,?,?)", user_id,product_id,num,null);
	}
	
	@Override
	public void update(int user_id,int product_id,int num) {
		JdbcUtilC3P0.update("update t_cart set num=? where user_id=? and product_id=?", num,user_id,product_id);
	}
	
	@Override
	public List<Cart> selectForPage(int page, int rows) {
		return JdbcUtilC3P0.findList(Cart.class, page, rows, "select * from t_cart");
	}

	@Override
	public Cart selectOne(int user_id, int product_id) {
		return JdbcUtilC3P0.findOne(Cart.class, "select * from t_cart where user_id=? and product_id=?", user_id,product_id);
	}

	@Override
	public List<Cart> selectAll(int u_id) {
		return JdbcUtilC3P0.findList(Cart.class, "select * from t_cart where user_id=?",u_id);
	}

	@Override
	public void delete(int id) {
		JdbcUtilC3P0.update("delete from t_cart where id=?", id);
		
	}

	@Override
	public void clear(int user_id) {
		JdbcUtilC3P0.update("delete from t_cart where user_id=?", user_id);		
	}

	@Override
	public Cart selectOne(int id) {
		return JdbcUtilC3P0.findOne(Cart.class, "select * from t_cart where id=?", id);
	}

	@Override
	public void add(Cart cart) {
		JdbcUtilC3P0.update("insert into t_cart values(t_cart_seq.nextval,?,?,?,?)", cart.getProduct_id(),cart.getProduct_id(),cart.getNum(),cart.getRemark());		
	}

	@Override
	public void update(Cart cart) {
		JdbcUtilC3P0.update("update t_cart set num=? where id=?", cart.getNum(),cart.getId());		
	}


}
