<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import = "repository.*"%>
<%@ page import = "vo.*"%>
<%
	if(session.getAttribute("customerId")!=null){
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=already");
		return;
	}

	CustomerDao customerDao = new CustomerDao();
	Customer customer = new Customer();
	
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("CustomerId");
	customer.setId(id);
	Customer customer1 = customerDao.login(customer);
	
	if(customer == null){
		System.out.println("실패");
		response.sendRedirect(request.getContextPath()+"/index.jsp?errMsg=error");
		return;
	}
	
	out.println("로그인 성공");
	session.setAttribute("customer1", customer1);
	response.sendRedirect(request.getContextPath()+"/CustomerDetail.jsp");

%>