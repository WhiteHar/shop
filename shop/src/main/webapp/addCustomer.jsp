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
		request.getParameter("ckId") != null{	// ckId가 null이 아닐 경우=> 이
			ckId = request.getParameter("ckId");
				
		}
	%>
	<form action="<%=request.getContextPath() %>/idCheckAction.jsp" method="post">
		<table border="1">
			<tr>
				<td>
					<input type="text" name ="customerId" id="customerId">
		
		
		</table>
	<!-- 
		addCustomer(addEmployee)
		1) 아이디 중복 체크 : addCustomer > idCheckAction > SignService > SignDao
		2) 회원가입: addCustomer > addCustomerAction > CustomerService > CustomerDao
	
	
	 -->
	
	</form>
</body>
</html>