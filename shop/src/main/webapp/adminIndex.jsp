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
		<ul>
			<li><a href="<%=request.getContextPath() %>/adminIndex.jsp">사원관리</a></li>
			<li><a href="<%=request.getContextPath() %>/adminGoodsList.jsp">상품관리</a></li>	<!-- 상품목록/등록/수정(품절)/삭제(장바구니, 주문이 없는 경우) -->
			<li><a href="<%=request.getContextPath() %>/adminOrdersList.jsp">주문관리</a></li>	<!-- 주문목록/수정 -->
			<li><a href="<%=request.getContextPath() %>/adminCustomerList.jsp">고객관리</a></li>	<!-- 고객목록/강제탈퇴/비밀번호 수정 -->
			<li><a href="<%=request.getContextPath() %>/adminNoticeList.jsp">공지관리</a></li>	<!-- 공지 CRUD -->
		</ul>
	</div>
	<h1>사원관리</h1>
	<div>
		<!-- 사원목록, acticve값 수정 -->
	
	
	</div>
</body>
</html>