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
		// ����ҳ���С
		int rows = 2;
		// ��ȡҳ
		int page = Integer.parseInt(request.getParameter("page"));
		// ����service�Ĳ�ѯ���� ��ѯÿҳ������
		List<Supplier> suppliers = supplierService.selectSupplierForPage(page, rows);
		// ������
		request.setAttribute("suppliers", suppliers);
		// ��page
		request.setAttribute("page", page);
		int totalPage = 0;	int totalCount = 0; // totalCount��¼�ܼ�¼��
		// ����service�Ĳ�ѯ���� ��ѯ�˵���Ϣ
		List<Supplier> supplier2 = supplierService.selectAll();
		// �ж����ݴ�С
		if (null != supplier2 && supplier2.size() > 0) {
			// ��ȡ�ܼ�¼��
			totalCount = supplier2.size();
			// ������ҳ��
			totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount/ rows + 1;
			// ���ܼ�¼��
			request.getSession().setAttribute("totalCount", totalCount);
			// ����ҳ��
			request.getSession().setAttribute("totalPage", totalPage);
		} else {
			// ���ܼ�¼��
			request.getSession().setAttribute("totalCount", 0);
			// ����ҳ��
			request.getSession().setAttribute("totalPage", 0);
		}

		// ת������providerAdmin.jsp
		request.getRequestDispatcher("providerAdmin.jsp").forward(request,
				response);
	}

}
