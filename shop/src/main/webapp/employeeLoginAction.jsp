<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="repository.*"%>
<%@ page import="vo.Employee" %>
<%@ page import="service.EmployeeService" %>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("employeeId");
	String pass = request.getParameter("employeePass");
	
	// 디버깅
	System.out.println("employeeLoginAction.jsp id : " + id);
	System.out.println("employeeLoginAction.jsp pass : " + pass);
	
	if(session.getAttribute("id") !=null){
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=already");
		return;
	}
	if(id==null || pass==null ){
		response.sendRedirect(request.getContextPath() + "/theme/loginForm.jsp?errorMsg=wrong ID or PW");
		return;
	}
	
	Employee member = new Employee();
	member.setId(id);
	member.setPass(pass);
	// 디버깅
	System.out.println("member.getId: " + member.getId());
	System.out.println("member.getPass: " + member.getPass());
	
	EmployeeService employeeService = new EmployeeService();
	Employee loginEmployee = new Employee();
	loginEmployee = employeeService.login(member);
	
	if(loginEmployee == null){
		System.out.println("로그인 실패");
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=please login again");
		return;
	}else{
		session.setAttribute("user", "Employee");
		session.setAttribute("id", loginEmployee.getId());
		session.setAttribute("name", loginEmployee.getName());
		
		System.out.println(session.getAttribute("id"));
		System.out.println("로그인 성공");
		response.sendRedirect(request.getContextPath()+"/adminIndex.jsp");
	}
%>
