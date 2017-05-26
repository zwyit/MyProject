package com.xx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xx.entity.Supplier;
import com.xx.service.SupplierService;
import com.xx.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class AddSupplierServlet
 */
public class AddSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierService supplierService=new SupplierServiceImpl();
       
    public AddSupplierServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//实现供应商的添加
		//获取供应商信息
		Integer supplierCode=Integer.valueOf(request.getParameter("proId"));//供应商编号
		String supplierName=request.getParameter("proName");//供应商名称
		String supplierDexc=request.getParameter("proDesc");//供应商描述
		String supplierPerson=request.getParameter("contact");//供应商联系人
		Long supplierTel=Long.valueOf(request.getParameter("phone"));//供应商电话
		String supplierChuan=request.getParameter("fax");//供应商传真
		String supplierAddr=request.getParameter("address");//供应商传真
		//创建供应商对象
		Supplier supplier=new Supplier();
		supplier.setSupplierCode(supplierCode);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDexc(supplierDexc);
		supplier.setSupplierPerson(supplierPerson);
		supplier.setSupplierTel(supplierTel);
		supplier.setSupplierChuan(supplierChuan);
		supplier.setSupplierAddr(supplierAddr);
		//请求服务
		supplierService.save(supplier);
		//转发
		request.getRequestDispatcher("QuerySupplierServlet?page=1").forward(request, response);
	}
}
