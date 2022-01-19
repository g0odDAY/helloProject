<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function formSubmit(id){ 
	document.forms.frm.id.value=id;
document.forms.frm.submit(); };
</script>

<form id="frm" name="frm"
	action="${pageContext.request.contextPath}/noticeSelect.do"
	method="post">
	<input type="hidden" name="id">
</form>
<table class="table">
	<thead>
		<tr>
			<th>공지번호</th>
			<th>공지제목</th>
			<th>공지내용</th>
			<th>공지작성일시</th>
			<th>공지조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="n" items="${noticeList }">
			<tr onclick="formSubmit(${n.noticeId})">
				<td>${n.noticeId }</td>
				<td>${n.noticeTitle }</td>
				<td>${n.noticeContent }</td>
				<td>${n.noticeDate }</td>
				<td>${n.noticeHit }</td>
			</tr>
		</c:forEach>

	</tbody>




</table>
<a href="${pageContext.request.contextPath }/noticeForm.do">공지등록</a>