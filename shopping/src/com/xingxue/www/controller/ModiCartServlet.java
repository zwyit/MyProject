package com.xingxue.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xingxue.www.entity.Cart;
import com.xingxue.www.service.CartService;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.imp.CartServiceImpl;
import com.xingxue.www.service.imp.ProductServiceImpl;

/**
 * Servlet implementation class ModiCartServlet
 */
public class ModiCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartService cartService=new CartServiceImpl();
    private ProductService productService=new ProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModiCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取变量
		int temp=Integer.parseInt(request.getParameter("lag"));
//		System.out.println("添加："+temp);
		//获取购物车id
		Integer id=Integer.parseInt(request.getParameter("id"));
//		System.out.println("购物车id:"+id);
		//获取购物车对象
		Cart cart=cartService.selectOne(id);
		//获取用户id
//		int user_id=cart.getUser_id();
		//获取产品id
		Integer product_id=cart.getProduct_id();
		//获取产品总数量count
		Integer count=productService.selectOne(product_id).getCount();
		//购物车中已有数量
		int num=cart.getNum();
		
		if(temp>0){
			if(num+1<=count){
				cart.setNum(cart.getNum()+1);
				cartService.update(cart);
			}
		}else{
			if(num-1>0){
				cart.setNum(cart.getNum()-1);
				cartService.update(cart);
			}else{
				cartService.delete(id);
			}
		}
		request.getRequestDispatcher("QueryCartServlet").forward(request, response);
	}

}
