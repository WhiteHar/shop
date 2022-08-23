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
	boolean removeComplete = false;
	
	if(id==null || pw==null){
		System.out.println("id, pw값이 null");
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=Not logged in");
	}
	
	Employee employee = new Employee();
	employee.setId(id);
	employee.setPass(pw);
	
	EmployeeService service = new EmployeeService();
	removeComplete = service.removeEmployee(employee);
	
	if(removeComplete){
		System.out.println("remove success");
		session.invalidate(); // 세션 비우기
		// 재요청
		response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
	} else {
		System.out.println("remove failed");
		// 재요청
		response.sendRedirect(request.getContextPath() + "/index.jsp?errorMsg=remove account Fail");
	}
	
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