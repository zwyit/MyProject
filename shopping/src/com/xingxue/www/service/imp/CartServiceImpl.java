package com.xingxue.www.service.imp;

import java.util.List;

import com.xingxue.www.dao.CartDAO;
import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.entity.Cart;
import com.xingxue.www.entity.Product;
import com.xingxue.www.service.CartService;
import com.xingxue.www.util.DAOFactory;
import com.xingxue.www.util.JdbcUtil;

public class CartServiceImpl implements CartService {
	private CartDAO cartDAO=DAOFactory.getCartDao();
	private ProductDAO productDAO=DAOFactory.getProductDAO();
	
	@Override
	public void add(int user_id,int product_id,int num) {
		try{
			cartDAO.add(user_id, product_id, num);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void update(int user_id,int product_id,int num) {
		Cart cart=cartDAO.selectOne(user_id, product_id);
		try{
			if(cart==null){
				cartDAO.add(user_id, product_id, num);
			}else{
				int OldNum=cart.getNum();
				int newNum=OldNum+num;
				cartDAO.update(user_id, product_id, newNum);
			}
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public List<Cart> selectForPage(int page, int rows) {
		try{
			return cartDAO.selectForPage(page, rows);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public Cart selectOne(int user_id, int product_id) {
		try {
			return cartDAO.selectOne(user_id, product_id);
		} finally{
			JdbcUtil.close();
		}
	}

	@Override
	public List<Cart> selectAll(int u_id) {
		try{
			List<Cart> clist=cartDAO.selectAll(u_id);
			for(Cart cart:clist){
				Product product=productDAO.selectOne(cart.getProduct_id());
				cart.setProduct(product);
			}
			return clist;
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void delete(int id) {
		try{
			cartDAO.delete(id);
		}finally{
			JdbcUtil.close();
		}
		
	}

	@Override
	public void clear(int user_id) {
		try{
			cartDAO.clear(user_id);
		}finally{
			JdbcUtil.close();
		}		
	}

	@Override
	public Cart selectOne(int id) {
		try {
			return cartDAO.selectOne(id);
		} finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void add(Cart cart) {
		try{
			cartDAO.add(cart);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void update(Cart cart) {
		Cart cart2=cartDAO.selectOne(cart.getId());
		try{
			if(cart2==null){
				cartDAO.add(cart);
			}else{
				cartDAO.update(cart);
			}
		}finally{
			JdbcUtil.close();
		}
	}
}
