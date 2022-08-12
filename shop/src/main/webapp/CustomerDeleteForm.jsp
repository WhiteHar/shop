<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "repository.*"%>
<%@ page import = "vo.*"%>
<%
	if(session.getAttribute("loginCustomer") ==null){
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp");
		return;
	}

	Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
	CustomerDao customerDao = new CustomerDao();
	Customer customer = customerDao.selectCustomerOne(loginCustomer.getId());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./deleteCustomerAction.jsp" method="post">
		<input type="hidden" name="CustomerId" value="<%=customer.getId() %>">
		비밀번호를 입력하시오.
		<input type="password" name="CustomerPw">
		<button type="submit">DELETE</button>
	</form>
</body>
</html>