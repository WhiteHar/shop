<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="service.EmployeeService"%>
<%
if(session.getAttribute("id") == null){
   		response.sendRedirect(request.getContextPath() + "/theme/loginForm.jsp?errorMsg=Not logged in");
   		return;
   	} else if(session.getAttribute("id") != null && "customer".equals((String)session.getAttribute("user"))) {
   		response.sendRedirect(request.getContextPath() + "/theme/index.jsp?errorMsg=No permission");
   	}

	String employeeId = request.getParameter("employeeId");
	String active = request.getParameter("active");
	// 디버깅
	System.out.println("updateActive.jsp employeeId : " + employeeId);
	System.out.println("updateActive.jsp active : " + active);
	

	EmployeeService employeeService = new EmployeeService();
	boolean activeUpdate = employeeService.modifyActiveById(employeeId, active);

	if(activeUpdate){ // 성공
		System.out.println("updateActive.jsp update 성공");
		response.sendRedirect(request.getContextPath() + "/theme/employeeList.jsp");
	} else { // 실패
		System.out.println("updateActive.jsp update 실패");
		response.sendRedirect(request.getContextPath() + "/theme/employeeList.jsp?errorMsg=active update Fail");
	}



%>