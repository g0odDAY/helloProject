<%@page import="com.edu.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>사용자이름은 : ${ login.name }입니다.</h3>
<h3>히원리스트</h3>
	<c:choose>
		<c:when test="${empty memberList }">
		
		<p>조회된 정보가 없습니다.</p>
		</c:when>
		<c:otherwise>
			<table border="1">
				<thead>
					<tr>
						<th>이름</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이메일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${memberList }">
						<tr>
							<td>${member.name }</td>
							<td>${member.id }</td>
							<td>${member.passwd }</td>
							<td>${member.mail }</td>
						</tr>
						
						
					</c:forEach>
				
				</tbody>
			
			
			</table>
		</c:otherwise>
	</c:choose>
</body>
	
</html>