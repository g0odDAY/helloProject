<%@page import="com.edu.model.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commentDetail.jsp</title>
</head>
<body>
	<%
		CommentVO vo=(CommentVO)request.getAttribute("comment");
	%>
	<table>
		<tr>
			<th>아이디</th>
			<td><%=vo.getId()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=vo.getName()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=vo.getContent()%></td>
		</tr>
		
	</table>
	<div>
		<button id="updateBtn">수정</button>
		<button id="deleteBtn">삭제</button>
	</div>
	<script>
	console.log('111');
		document.getElementById('updateBtn').addEventListener('click',updateCommentForm);
		function updateCommentForm(){
			var id=document.querySelector('table>tbody>tr>td:nth-of-type(1)').innerText;
			
			window.location.href = 'comment/commentUpdateForm.jsp?id='+id;
		}
		document.getElementById('deleteBtn').addEventListener('click',deleteComment);
		
		function deleteComment(){
			
		}
		
	</script>

</body>
</html>