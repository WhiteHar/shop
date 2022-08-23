<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="repository.*" %>
<%@ page import="vo.*" %>
<%
	if(session.getAttribute("employeeId")!=null){
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=already");
		return;
	}
	
	EmployeeDao employeeDao = new EmployeeDao();
	Employee employee = new Employee();
	
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("EmployeeId");
	
	employee.setId(id);
	Employee employee1 = employeeDao.login(employee);
	
	if(employee1 == null){
		System.out.println("실패");
		response.sendRedirect(request.getContextPath()+"/index.jsp?errMsg=error");
		return;
	}
	
	out.println("로그인 성공");
	response.sendRedirect(request.getContextPath()+"/CustomerDatail.jsp");
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