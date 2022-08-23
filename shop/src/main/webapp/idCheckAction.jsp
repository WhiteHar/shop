<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.SignService"%>
<%@ page import="repository.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="vo.*"%>
<%	
	if(session.getAttribute("id") != null){
		response.sendRedirect(request.getContextPath() + "index.jsp?errorMsg=wrong Path");
		return;
	}

	SignDao signDao = new SignDao();
	
	request.setCharacterEncoding("utf-8");
	
	String ckId = request.getParameter("ckid");
	String N = request.getParameter("c");
	
	System.out.println("idCheckAcion.jsp user : " + N);
	System.out.println("idCheckAcion.jsp ckId : " + ckId);
	
	SignService service = new SignService();
	boolean ckIdComplete = service.idCheck(ckId);
	
	if(ckIdComplete && N.equals("customer")){
		// true && customer
		response.sendRedirect(request.getContextPath() + "sign-up.jsp?customerCkId=" + ckId);
	} else if(ckIdComplete && N.equals("employee")){
		// true && employee 
		response.sendRedirect(request.getContextPath() + "sign-up.jsp?employeeCkId=" + ckId);
	} else {
		// false 
		response.sendRedirect(request.getContextPath() + "sign-up.jsp?errorMsg=Duplicate ID");
	}
		
%>
