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
		<h2>계정 탈퇴</h2>
			<form id="removeForm" action="<%=request.getContextPath()%>/removeIdAction.jsp" method="post">
				<div>
					<input class="form-control" type="password" name="Pass" id="Pass" placeholder="비밀번호">
				</div>
				<button type="button" class="btn btn-danger  btn-block" id="removebtn">탈퇴</button>
			</form>
	</div>
</body>
</html>
