package com.xx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xx.entity.Users;
import com.xx.service.UserService;
import com.xx.service.impl.UserServiceImpl;

/**
 * Servlet implementation class QueryUsersServlet
 */
public class QueryUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUsersServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查数据
		List<Users> users=userService.selectAll();
		//存数据
		request.setAttribute("users", users);
		//转发
		request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
	}

}
