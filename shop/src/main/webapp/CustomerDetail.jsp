<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "repository.*" %>
<%@ page import = "vo.Customer" %>
<%
	Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
	CustomerDao customerDao  = new CustomerDao();
	Customer customer = customerDao.selectCustomerOne(loginCustomer.getId());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<a href = "./index.jsp">로그인 페이지로</a>
		</div>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>
					<input type = "hidden" value="Customer" name="CustomerId" id="CustomerId">
					<%=customer.getId() %>
				</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><%=customer.getName()%></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><%=customer.getAddress()%></td>
			</tr>
			<tr>
				<td>TELEPHONE</td>
				<td><%=customer.getPhone()%></td>
			</tr>
			<tr>
		</table>
		<a href="./">비밀번호 변경</a>
		<a href="./">계정정보 수정</a>
		<a href="<%=request.getContextPath()%>/Customerdelete.jsp?CustomerId=<%=customer.getId()%>">계정 정보 삭제</a>
	</div>

</body>
</html>