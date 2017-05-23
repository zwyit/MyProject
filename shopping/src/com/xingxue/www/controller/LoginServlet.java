package com.xingxue.www.controller;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xingxue.www.entity.User;
import com.xingxue.www.service.UserService;
import com.xingxue.www.service.imp.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=new UserServiceImpl();  
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String user_name=request.getParameter("name");
		String user_password=request.getParameter("pwd");
		User user=userService.selectOne(user_name);
		//�ж��û����Ƿ����
		if((user_name.equals(user.getUser_name()))&&(user_password.equals(user.getUser_password()))){
			//session���д�ȡ
			request.getSession().setAttribute("username", user_name);
//			request.getRequestDispatcher("QueryProductServlet").forward(request, response);
			response.sendRedirect("QueryProductServlet?page=1");
		}else{
			request.setAttribute("message", "�˻���������������µ�¼");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
			response.sendRedirect("login.jsp");
		}		
	}

}
