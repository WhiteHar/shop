<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="repository.*"%>
<%@ page import="service.EmployeeService" %>
<%@ page import="vo.*" %>
<%@ page import="java.sql.*" %>
<% 
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("EmployeeId");
	String pw = request.getParameter("EmployeePw");
	
	if(id==null || pw==null){
		System.out.println("id, pw값이 null");
		response.sendRedirect(request.getContextPath()+"./loginForm.jsp");
	}
	
	Employee employee = new Employee();
	employee.setId(id);
	employee.setPass(pw);
	
	EmployeeService service = new EmployeeService();
	service.removeEmployee(employee);
	System.out.println("로그인 성공");
	response.sendRedirect(request.getContextPath()+"/loginForm.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>