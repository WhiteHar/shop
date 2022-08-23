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
		<h1><%=session.getAttribute("user")%><!-- customer / employee --></h1>
		<table>
			<tr>
				<td>id</td>	
				<td><%=session.getAttribute("id") %>	<!-- 로그인 아이디 --></td>
			</tr>
		<br>
			<tr>
				<td>name</td>
				<td><%=session.getAttribute("name") %>	<!-- 로그인 이름 --></td>
			</tr>
		</table>
		<br>
		<div>
			<a href = "<%=request.getContextPath() %>/logout.jsp">로그아웃</a>
		</div>
	</div>
</body>
</html>