package com.xx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xx.entity.Supplier;
import com.xx.service.SupplierService;
import com.xx.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class UpdateSupplierServlet
 */
public class UpdateSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SupplierService supplierService=new SupplierServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierServlet() {
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
		//处理请求编码格式
		request.setCharacterEncoding("utf-8");
		Integer s_id=Integer.valueOf(request.getParameter("s_id"));
		Integer supplierCode=Integer.valueOf(request.getParameter("supplierCode"));
//		System.out.println(supplierCode);
		String supplierName=request.getParameter("supplierName");
//		System.out.println(supplierName);
		String supplierDexc=request.getParameter("supplierDexc");
		System.out.println(supplierDexc);
		String supplierPerson=request.getParameter("supplierPerson");
		System.out.println(supplierPerson);
		Long supplierTel=Long.valueOf(request.getParameter("supplierTel"));
		String supplierAddr=request.getParameter("supplierAddr");
		
		Supplier supplier=new Supplier();
		supplier.setS_id(s_id);
		supplier.setSupplierCode(supplierCode);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDexc(supplierDexc);
		supplier.setSupplierPerson(supplierPerson);
		supplier.setSupplierTel(supplierTel);
		supplier.setSupplierAddr(supplierAddr);
		
		supplierService.update(supplier);
			
		request.getRequestDispatcher("QuerySupplierServlet?page=1").forward(request,response);
		
	}

}
