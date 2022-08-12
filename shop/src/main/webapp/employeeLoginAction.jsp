<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="repository.*"%>
<%@ page import="vo.Employee" %>
<%
	if(session.getAttribute("id") !=null){
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=already");
		return;
	}
	
	EmployeeDao employeeDao = new EmployeeDao();
	Employee member = new Employee();
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("employeeId");
	String pass = request.getParameter("employeePass");
	
	// 디버깅
	System.out.println("id: " + id);
	System.out.println("pass: " + pass);
	
	member.setId(id);
	member.setPass(pass);
	// 디버깅
	System.out.println("member.getId: " + member.getId());
	System.out.println("member.getPass: " + member.getPass());
	
	Employee loginEmployee = employeeDao.login(member);
	if(loginEmployee == null){
		System.out.println("로그인 실패");
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=please login again");
		return;
	}
	session.setAttribute("user", "Employee");
	session.setAttribute("id", loginEmployee.getId());
	System.out.println(session.getAttribute("id"));
	session.setAttribute("name", loginEmployee.getName());
	
	System.out.println("로그인 성공");
	session.setAttribute("loginEmployee", loginEmployee);
	response.sendRedirect(request.getContextPath()+"/adminIndex.jsp");
%>
