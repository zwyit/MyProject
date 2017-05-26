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
 * Servlet implementation class UpdateUsersServlet
 */
public class UpdateUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=new UserServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsersServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理请求编码格式
		request.setCharacterEncoding("utf-8");
		//获取修改的信息
		Integer u_id=Integer.parseInt(request.getParameter("u_id"));
		String  userName=request.getParameter("userName");
		String  userPassword=request.getParameter("userPassword");
		Long userTel=Long.parseLong(request.getParameter("userTel"));
		String userAddr=request.getParameter("userAddr");
		Integer userRight=Integer.parseInt(request.getParameter("userRight"));
		//创建对象
		Users users=new Users();
		users.setU_id(u_id);
		users.setUserName(userName);
		users.setUserPassword(userPassword);
		users.setUserTel(userTel);
		users.setUserAddr(userAddr);
		users.setUserRight(userRight);
		//修改用户信息
		userService.update(users);
		//请求转发
		request.getRequestDispatcher("QueryUsersServlet").forward(request, response);
	}

}
