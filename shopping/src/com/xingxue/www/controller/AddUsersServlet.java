package com.xingxue.www.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xingxue.www.entity.User;
import com.xingxue.www.service.UserService;
import com.xingxue.www.service.imp.UserServiceImpl;

/**
 * Servlet implementation class AddUsersServlet
 */
public class AddUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=new UserServiceImpl();
     /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取注册信息
		String user_name=request.getParameter("name");
		String user_password=request.getParameter("pwd");
		User user=userService.selectOne(user_name);
		if(user==null){
			User user2=new User();
			user2.setUser_name(user_name);
			user2.setUser_password(user_password);
			userService.save(user2);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "用户名已存在,请重新注册！");
			request.getRequestDispatcher("zhuce.jsp").forward(request, response);
		}
	}

}
