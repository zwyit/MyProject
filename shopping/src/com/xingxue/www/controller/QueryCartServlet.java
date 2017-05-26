package com.xingxue.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xingxue.www.entity.Cart;
import com.xingxue.www.entity.User;
import com.xingxue.www.service.CartService;
import com.xingxue.www.service.UserService;
import com.xingxue.www.service.imp.CartServiceImpl;
import com.xingxue.www.service.imp.UserServiceImpl;

/**
 * Servlet implementation class QueryCartServlet
 */
public class QueryCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartService cartService=new CartServiceImpl();
    private UserService userService=new UserServiceImpl();
    public QueryCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名
		request.getSession().getAttribute("username");
		String name=(String)request.getSession().getAttribute("username");
		if(name==null){
			response.sendRedirect("login.jsp");
		}else {
			User user=userService.selectOne(name);
			List<Cart> carts=cartService.selectAll(user.getId());
			request.setAttribute("carts", carts);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
	}

}
