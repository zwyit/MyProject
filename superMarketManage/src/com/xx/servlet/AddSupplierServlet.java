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
		//ʵ�ֹ�Ӧ�̵����
		//��ȡ��Ӧ����Ϣ
		Integer supplierCode=Integer.valueOf(request.getParameter("proId"));//��Ӧ�̱��
		String supplierName=request.getParameter("proName");//��Ӧ������
		String supplierDexc=request.getParameter("proDesc");//��Ӧ������
		String supplierPerson=request.getParameter("contact");//��Ӧ����ϵ��
		Long supplierTel=Long.valueOf(request.getParameter("phone"));//��Ӧ�̵绰
		String supplierChuan=request.getParameter("fax");//��Ӧ�̴���
		String supplierAddr=request.getParameter("address");//��Ӧ�̴���
		//������Ӧ�̶���
		Supplier supplier=new Supplier();
		supplier.setSupplierCode(supplierCode);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDexc(supplierDexc);
		supplier.setSupplierPerson(supplierPerson);
		supplier.setSupplierTel(supplierTel);
		supplier.setSupplierChuan(supplierChuan);
		supplier.setSupplierAddr(supplierAddr);
		//�������
		supplierService.save(supplier);
		//ת��
		request.getRequestDispatcher("QuerySupplierServlet?page=1").forward(request, response);
	}
}
