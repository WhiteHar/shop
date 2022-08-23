<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="repository.*"%>
<%@ page import="vo.Customer" %>
<%@ page import="service.CustomerService""%>
<%
	
	
	// member 객체 생성
	Customer member = new Customer();

	// 인코딩
	request.setCharacterEncoding("utf-8");
	
	// id, pw값 받아오기
	String id = request.getParameter("customerId");	// loginForm.jsp 내 customerId 입력값
	String pass = request.getParameter("customerPass");
	
	// 디버깅
	System.out.println("id: " + id);
	System.out.println("pass: " + pass);
	
	// 세션에서 조회한 id값이 null이 아닐 경우 => 
	if(session.getAttribute("id") !=null){
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=already");
		return;
	}

	// 정보 삽입(set)
	member.setId(id);	// 앞서 선언한 id값을 Customer 형식의 member변수 내에 저장
	member.setPass(pass);
	
	// 디버깅
	System.out.println("member.getId: " + member.getId());
	System.out.println("member.getPass: " + member.getPass());
	

	CustomerService customerService = new CustomerService();
	Customer loginCustomer = customerService.login(member);	// loginCustomer: member변수로 customerDao 내의 login 메서드를 실행
	
	// DB에 일치하는 id가 없을 때
	if(loginCustomer == null){
		System.out.println("로그인 실패");
		response.sendRedirect(request.getContextPath()+"/loginForm.jsp?errorMsg=please login again");
	}else{	//성공 시
		session.setAttribute("user", "CUSTOMER");
		session.setAttribute("id",  loginCustomer.getId());
		session.setAttribute("name", loginCustomer.getName());
		
		System.out.println("로그인 성공");
		session.setAttribute("loginCustomer", loginCustomer);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
%>