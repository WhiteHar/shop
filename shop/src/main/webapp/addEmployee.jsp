<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<!-- id check form -->
		<form action="<%=request.getContextPath()%>/idCheckAction.jsp" method="post">
			<div>
				ID 체크
				<input type="text" name="ckId"><input type="hidden" name="c" id="c" value="Employee">
				<button type="submit">아이디 중복검사</button>
			</div>			
		</form>
	</div>
	<!-- 고객 회원가입 form  -->
	<%
		String ckId = "";
		if(request.getParameter("ckId")!= null){
			ckId = request.getParameter("ckId");
		}
	%>
	<div>
		<form action="<%=request.getContextPath()%>/insertEmployeeAction.jsp" method="post">
			<table border="1">
				<tr>
					<td>EmployeeId</td>
					<td><input type="text" name="EmployeeId" id="EmployeeId" readonly="readonly" value="<%=ckId%>"></td>
				</tr>
				<tr>
					<td>EmployeePass</td>
					<td><input type="password" name="EmployeePass" id="EmployeePass"></td>
				</tr>
				<tr>
					<td>EmployeeName</td>
					<td><input type="text" name="EmployeeName" id="EmployeeName"></td>
				</tr>
			</table>
			<button type="submit">추가</button>
			<button type="reset">초기화</button>
		</form>
	</div>
</body>
</html>