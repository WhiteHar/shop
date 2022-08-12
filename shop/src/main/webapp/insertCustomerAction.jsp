<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="service.CustomerService" %>
<%@ page import="repository.*" %>
<%@ page import="vo.*" %>
<%
	CustomerDao customerDao = new CustomerDao();
	Customer customer = new Customer();
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("customerId");
	String pw = request.getParameter("customerPass");
	String name = request.getParameter("custerName");
	String address = request.getParameter("customerAddress");
	String telephone = request.getParameter("custoemrTelephone");
	
	System.out.println(id);
	System.out.println(pw);
	System.out.println(name);
	System.out.println(address);
	System.out.println(telephone);
	
	customer.setId(id);
	customer.setPass(pw);
	customer.setName(name);
	customer.setAddress(address);
	customer.setPhone(telephone);
	
	CustomerService service = new CustomerService();
	service.login(customer);
	response.sendRedirect(request.getContextPath()+"/loginForm.jsp");
	
%>
