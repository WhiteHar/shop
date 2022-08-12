<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.SignService"%>
<%@ page import="repository.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="vo.*"%>
<%
	SignDao signDao = new SignDao();

	request.setCharacterEncoding("utf-8");
	String ckId= request.getParameter("ckId");
	String N = request.getParameter("c");
	
	SignService service = new SignService();
	if(service.idCheck(ckId)==false){
	// service -> false
	// 사용 불가
		System.out.println("사용 불가");
		if(N.equals("Customer")){
			response.sendRedirect(request.getContextPath()+"/addCustomer.jsp?errorMsg=ID not used");
		} else {
			response.sendRedirect(request.getContextPath()+"/addEmployee.jsp?errorMsg=ID not used")
		}
	} else{
		// srvice -> true
		// 사용 가능
		serivice.idCheck(ckId);
		if(N.equals("Customer")){
			System.out.println("사용가능");
			response.sendRedirect(request.getContextPath()+"/addCustomer.jsp?ckId="+ckId);
		} else{
			response.sendRedirect(request.getContextPath()+"/addEmployee.jsp?ckId="+ckId);
		}
	}
	
%>
