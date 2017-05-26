package com.xx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xx.entity.Users;
import com.xx.service.UserService;
import com.xx.service.impl.UserServiceImpl;

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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//增加用户
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取用户信息
		Integer userCode=Integer.valueOf(request.getParameter("userId"));
		String userName=request.getParameter("username");
		String userPassword=request.getParameter("password");
		Integer userSex=Integer.valueOf(request.getParameter("sex"));
		Integer userAge=Integer.valueOf(request.getParameter("age"));
		Long userTel=Long.valueOf(request.getParameter("mobile"));
		String userAddr=request.getParameter("address");
		Integer userRight=Integer.valueOf(request.getParameter("auth"));
		//创建对象
		Users users=new Users();
		users.setUserCode(userCode);
		users.setUserName(userName);
		users.setUserPassword(userPassword);
		users.setUserSex(userSex);
		users.setUserAge(userAge);
		users.setUserTel(userTel);
		users.setUserAddr(userAddr);
		users.setUserRight(userRight);
		//请求服务
		userService.save(users);
		//转发
		request.getRequestDispatcher("QueryUsersServlet").forward(request, response);
	}

}
