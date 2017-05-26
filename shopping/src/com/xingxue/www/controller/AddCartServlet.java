package com.xingxue.www.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xingxue.www.entity.Cart;
import com.xingxue.www.entity.Product;
import com.xingxue.www.entity.User;
import com.xingxue.www.service.CartService;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.UserService;
import com.xingxue.www.service.imp.CartServiceImpl;
import com.xingxue.www.service.imp.ProductServiceImpl;
import com.xingxue.www.service.imp.UserServiceImpl;

public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartService cartService=new CartServiceImpl();
    private UserService userService=new UserServiceImpl();
    private ProductService productService=new ProductServiceImpl();
    public AddCartServlet() {
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
		//��ȡ�û���
		request.getSession().getAttribute("username");
		String name=(String)request.getSession().getAttribute("username");
		User user=userService.selectOne(name);
		//��ȡ��Ʒid
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		//��ȡ������Ʒ����
		int count=Integer.parseInt(request.getParameter("count"));
		//�ж��û��Ƿ��¼
		if(name==null){
			response.sendRedirect("login.jsp");
		}else{
			//�ж���Ʒ�Ƿ��Ѿ��ڹ��ﳵ
			cartService.update(user.getId(),product_id,count);
			//��ѯ�û��Լ��Ĺ��ﳵ��Ϣ
			List<Cart> carts=cartService.selectAll(user.getId());
			request.setAttribute("carts", carts);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}		
	}

}
