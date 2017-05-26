package com.xingxue.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xingxue.www.service.CartService;
import com.xingxue.www.service.imp.CartServiceImpl;

/**
 * Servlet implementation class DeleteCartServlet
 */
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartService cartService=new CartServiceImpl();
    public DeleteCartServlet() {
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
		//获取购物车id
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println("购物车id:"+id);
		cartService.delete(id);
		request.getRequestDispatcher("QueryCartServlet").forward(request, response);
	}

}
