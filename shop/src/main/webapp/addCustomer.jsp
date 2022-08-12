<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id check form -->
	<form action="<%=request.getContextPath() %>/idCheckAction.jsp" method="post">
		<div>
			ID체크
			<input type = "text" name="ckId">
			<button type = "submit">아이디 중복검사</button>
		</div>
	</form>
	
	<!-- 고객 가입 form -->
	<%
		String ckId;
		if(request.getParameter("ckId") != null){	// ckId가 null이 아닐 경우=> 이미 존재하는 아이디
			ckId = request.getParameter("ckId");		
		}
	%>
	<form action="<%=request.getContextPath() %>/insertCustomerAction.jsp" method="post">
		<table border="1">
			<tr>
				<td>customerId</td>
				<td>
					<input type="text" name ="customerId" id="customerId">
				</td>
			</tr>
			<tr>
				<td>customerPass</td>
				<td>
					<input type="password" name ="customerPass" id="customerPass">
				</td>
			</tr>
			<tr>
				<td>customerName</td>
				<td>
					<input type="text" name ="customerName" id="customerName">
				</td>
			</tr>
			<tr>
				<td>customerAddress</td>
				<td>
					<input type="text" name ="customerAddress" id="customerAddress">
				</td>
			</tr>
			<tr>
				<td>customerTelephone</td>
				<td>
					<input type="text" name ="customerTelephone" id="customerTelephone">
				</td>
			</tr>
		</table>
		<button type="submit">추가</button>
		<button type="reset">초기화</button>
	<!-- 
		addCustomer(addEmployee)
		1) 아이디 중복 체크 : addCustomer > idCheckAction > SignService > SignDao
		2) 회원가입: addCustomer > addCustomerAction > CustomerService > CustomerDao
	
	
	 -->
	
	</form>
</body>
</html>