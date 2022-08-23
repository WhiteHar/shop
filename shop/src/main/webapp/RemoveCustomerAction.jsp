<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.CustomerService" %>
<%@ page import="repository.*"%>
<%@ page import="vo.*"%>
<%@ page import="java.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("CustomerId");
	String pw = request.getParameter("CustomerPw");
	boolean removeComplete = false;
	
	if(id==null || pw==null){
		System.out.println("id, pw 값이 null");
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=Not logged in");
	}
	
	Customer customer = new Customer();
	customer.setId(id);
	customer.setPass(pw);

	CustomerService service = new CustomerService();
	removeComplete = service.removeCustomer(customer);
	
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