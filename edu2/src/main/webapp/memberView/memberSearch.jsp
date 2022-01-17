<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberVO vo=(MemberVO) request.getAttribute("member");
if(vo==null){
	out.println("<p>조회된 정보가 없습니다.</p>");
}
%>
	<h3>회원정보검색</h3>
	<form action="<%=request.getContextPath()%>/memberSearch.do " method="get">
		아이디:<input type="text" name="id"><br>
		<input type="hidden" name="job" value="search">
		<input type="submit" value="조회">
	</form>
</body>
</html>