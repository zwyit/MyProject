package com.xingxue.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xingxue.www.entity.Cart;
import com.xingxue.www.entity.User;
import com.xingxue.www.service.CartService;
import com.xingxue.www.service.UserService;
import com.xingxue.www.service.imp.CartServiceImpl;
import com.xingxue.www.service.imp.UserServiceImpl;

//从购物车点击结算后进入
public class QueryPreparedOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cartService=new CartServiceImpl();
	private UserService userService=new UserServiceImpl();
       
    public QueryPreparedOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户名
		String name=(String)request.getSession().getAttribute("username");
		if(name==null){
			response.sendRedirect("login.jsp");
		}else{
			//获取用户信息
			User user=userService.selectOne(name);
			//获取用户的购物车信息
			List<Cart> carts=cartService.selectAll(user.getId());
			//保存购物信息
			request.setAttribute("carts", carts);
			request.getRequestDispatcher("qrdz.jsp").forward(request, response);
		}
		
	}

}
