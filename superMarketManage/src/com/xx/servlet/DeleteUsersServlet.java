package com.xx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xx.entity.Users;
import com.xx.service.UserService;
import com.xx.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteUsersServlet
 */
public class DeleteUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=new UserServiceImpl();   
    
    public DeleteUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除用户
		//获取用户ID
		Integer u_id=Integer.valueOf(request.getParameter("u_id"));
		Users users=new Users();
		users.setU_id(u_id);
		userService.delete(users);
		//转发到QueryUsersServlet
		request.getRequestDispatcher("QueryUsersServlet").forward(request, response);
	}

}
