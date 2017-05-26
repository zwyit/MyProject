package com.xx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xx.entity.Supplier;
import com.xx.service.SupplierService;
import com.xx.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class DeleteSupplierServlet
 */
public class DeleteSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SupplierService supplierService=new SupplierServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSupplierServlet() {
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
		//实现供应商的删除
		Integer id=Integer.valueOf(request.getParameter("id"));
		Supplier supplier=new Supplier();
		supplier.setS_id(id);
		supplierService.delete(supplier);
		request.getRequestDispatcher("QuerySupplierServlet?page=id").forward(request, response);
	}

}
