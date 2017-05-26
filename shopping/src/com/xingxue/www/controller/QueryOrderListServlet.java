package com.xingxue.www.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xingxue.www.entity.User;
import com.xingxue.www.service.UserService;
import com.xingxue.www.service.imp.UserServiceImpl;

public class QueryOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=new UserServiceImpl();
    
    public QueryOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户名
		String name=(String)request.getSession().getAttribute("username");
		User user=userService.selectOne(name);
		if(user==null){
			response.sendRedirect("login.jsp");
		}else {
			request.getSession().getAttribute("order");
			request.getSession().getAttribute("olist");
			//转发
			request.getRequestDispatcher("ddzf.jsp").forward(request, response);
		}
	}

}
