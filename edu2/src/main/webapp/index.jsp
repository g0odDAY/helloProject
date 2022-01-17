<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫페이지(index.jsp)</title>
</head>
<body>
	<%
	MemberVO login = (MemberVO) session.getAttribute("login");
	if (login == null) {
		request.getRequestDispatcher("login/login.jsp").forward(request, response);
	} else {
	%>
	<h3><%=login.getName()%>님환영합니다.<button id="logout">로그아웃</button>
	</h3>
	<h3>글등록관련</h3>
	<a href='./comment/commentAdd.jsp'>글등록페이지</a>
	<br>
	<a href='./commentList.do'>글목록컨트롤러</a>
	<br>
	<a href='./comment/commentList.jsp'>글목록</a>
	<h3>회원등록관련</h3>
	<a href='memberView/memberInsert.jsp'>회원등록페이지</a>
	<br>
	<a href='memberView/memberSearch.jsp'>회원검색페이지</a>
	<br>
	<a href='memberView/memberDelete.jsp'>회원삭제페이지</a>
	<br>
	<a href='memberView/memberUpdate.jsp'>회원수정페이지</a>
	<br>
	<a href="./memberListAll.do">전체조회</a>
	<%
	}
	%>
	<script>
		document.getElementById('logout').addEventListener('click',logoutFnc);
		function logoutFnc(){
			<%
			
			%>
		}
	</script>
</body>
</html>