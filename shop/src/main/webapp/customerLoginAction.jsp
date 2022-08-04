<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
p

	// 인코딩
	request.setCharacterEncoding("utf-8");

	// id, pw값 받아오기
	String id = request.getParameter("customerId");
	String pass = request.getParameter("customerPass");
	
	// 디버깅
	System.out.println("id: " + id);
	System.out.println("pass: " + pass);
	
	// member 객체 생성
	Customer member = new Customer();
	// 정보 삽입(set)
	member.setId(id);
	member.setPass(pass);
	
	// 디버깅
	System.out.println("member.getId: " + member.getId());
	System.out.println("member.getPass: " + member.getPass());
	
	// CustomerDao 메서드 실행
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