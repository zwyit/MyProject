package com.xx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		//��ȡ�û���
		String name=request.getParameter("userName");
		//��ȡ�û�����
		String pwd=request.getParameter("passWord");
		if ("".equals(name)&&"".equals(pwd)) {
			request.getRequestDispatcher("admin_index.html").forward(request, response);
		}
		/*//�ж��˻��������Ƿ�Ϊadmin
		if ("admin".equals(name)&&"admin".equals(pwd)) {
			request.getRequestDispatcher("admin_index.html").forward(request, response);
		}else {
			request.getRequestDispatcher("login.html").forward(request, response);
		}*/
	}

}
