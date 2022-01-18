<%@page import="com.edu.model.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="name" value="kilgoong"></c:set>
	<c:out value="${name}"></c:out>
	<c:remove var="name"/>
	<c:out value="${name }"></c:out>
	<%
	CommentVO comment = new CommentVO();
	comment.setId(10);
	comment.setName("홍길동");
	comment.setContent("샘플");
	request.setAttribute("vo",comment);
	%>
	<c:set var="id" value="${vo.id }"></c:set>
	<c:out value="${id }"></c:out>
	
	<c:set var="name" value="${vo.name}"></c:set>
	<c:out value="${name }"></c:out>
	
	<c:set var="sname">hong</c:set>
	<c:out value="${sname }">></c:out>
	
	
	<c:set var="num" value="${80}"></c:set>
	<p>점수:<c:out value="${num }"></c:out></p>
	<c:if test="${num>60 }">
		<p>합격</p>
	</c:if>
	
	<c:choose>
		<c:when test="${num>90 }">A등급</c:when>
		<c:when test="${num>80 }">B등급</c:when>
		<c:when test="${num>70 }">C등급</c:when>
		<c:otherwise>D등급</c:otherwise>
	</c:choose>
</body>
</html>