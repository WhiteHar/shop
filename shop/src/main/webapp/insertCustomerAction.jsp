<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="service.CustomerService" %>
<%@ page import="service.EmployeeService" %>
<%@ page import="repository.*" %>
<%@ page import="vo.*" %>
<%
	CustomerDao customerDao = new CustomerDao();
	Customer customer = new Customer();
	request.setCharacterEncoding("utf-8");
	boolean insertComplete = false;
	if(session.getAttribute("id") != null){
		response.sendRedirect(request.getContextPath() + "index.jsp?errorMsg=wrong Path");
		return;
	}
	
	String user = request.getParameter("user");
	System.out.println("sign-upAcion.jsp user : " + user);	// 디버깅
	
	if(user.equals("customer")){
		String id = request.getParameter("customerId");
		String pw = request.getParameter("customerPass");
		String name = request.getParameter("customerName");
		String address = request.getParameter("customerAddress");
		String telephone = request.getParameter("customerTelephone");
		
		// 디버깅
		System.out.println("sign-upAcion.jsp id :" +id);
		System.out.println("sign-upAcion.jsp pw :" + pw);
		System.out.println("sign-upAcion.jsp name :" +name);
		System.out.println("sign-upAcion.jsp adress :" +address);
		System.out.println("sign-upAcion.jsp telephone :" +telephone);
		
	
		customer.setId(id);
		customer.setPass(pw);
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhone(telephone);
		
		CustomerService service = new CustomerService();
		insertComplete = service.addCustomer(customer);
		
	}else if(user.equals("employee")) {
		String id = request.getParameter("employeeId");
		String pw = request.getParameter("employeePass");
		String name = request.getParameter("employeeName");
		String address = request.getParameter("employeeAddress");
		String telephone = request.getParameter("employeeTelephone");
		Employee employee = new Employee();
		employee.setName(name);
		employee.setId(id);
		employee.setPass(pw);
		// 디버깅
		System.out.println(employee.toString());
		
		// 메서드실행할 employeeService 변수생성
		EmployeeService service = new EmployeeService();
		insertComplete = service.addEmployee(employee);
	}
	
	if(insertComplete){
		System.out.println("insert success");
		response.sendRedirect(request.getContextPath() + "loginForm.jsp");
	} else {
		System.out.println("insert failed");
		response.sendRedirect(request.getContextPath() + "sign-up.jsp?errorMsg=sign-up Fail");
	}
	
	response.sendRedirect(request.getContextPath()+"/loginForm.jsp");
%>
