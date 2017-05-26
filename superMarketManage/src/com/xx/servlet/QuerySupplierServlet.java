package com.xx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xx.entity.Supplier;
import com.xx.service.SupplierService;
import com.xx.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class QuerySupplierServlet
 */
public class QuerySupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SupplierService supplierService = new SupplierServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuerySupplierServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置页面大小
		int rows = 2;
		// 获取页
		int page = Integer.parseInt(request.getParameter("page"));
		// 调用service的查询方法 查询每页的数据
		List<Supplier> suppliers = supplierService.selectSupplierForPage(page, rows);
		// 存数据
		request.setAttribute("suppliers", suppliers);
		// 存page
		request.setAttribute("page", page);
		int totalPage = 0;	int totalCount = 0; // totalCount记录总记录数
		// 调用service的查询方法 查询账单信息
		List<Supplier> supplier2 = supplierService.selectAll();
		// 判断数据大小
		if (null != supplier2 && supplier2.size() > 0) {
			// 获取总记录数
			totalCount = supplier2.size();
			// 计算总页数
			totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount/ rows + 1;
			// 存总记录数
			request.getSession().setAttribute("totalCount", totalCount);
			// 存总页数
			request.getSession().setAttribute("totalPage", totalPage);
		} else {
			// 存总记录数
			request.getSession().setAttribute("totalCount", 0);
			// 存总页数
			request.getSession().setAttribute("totalPage", 0);
		}

		// 转发请求到providerAdmin.jsp
		request.getRequestDispatcher("providerAdmin.jsp").forward(request,
				response);
	}

}
