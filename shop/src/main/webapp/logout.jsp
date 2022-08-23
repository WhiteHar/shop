<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("id") == null){
		response.sendRedirect(request.getContextPath() + "loginForm.jsp?errorMsg=wrong path");
		return;
	}
	session.invalidate();		// 세션 리셋
	response.sendRedirect("./loginForm.jsp");
%>
