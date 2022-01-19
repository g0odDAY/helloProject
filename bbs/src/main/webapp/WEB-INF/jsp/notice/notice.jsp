<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
function deleteFnc(id){
	document.forms.delFrm.id.value=id;
	document.forms.delFrm.submit();
}
	
</script>
<form name="delFrm" action="${pageContext.request.contextPath }/noticeDelete.do"
method="post">
<input type="hidden" name="id">


</form>

<form action="${pageContext.request.contextPath }/noticeUpdate.do" method="post">
<input type="hidden" name="id" value="${notice.noticeId }">
<table class="table">
	<tbody>
		<tr>
			<th>공지번호</th>
			<td>${ notice.noticeId}</td>
		</tr>
		<tr>
			<th>공지제목</th>
			<td><input class="form-control" type="text" name="title" value="${ notice.noticeTitle}"></td>
		</tr>
		<tr>
			<th>공지내용</th>
			<td><textarea class="form-control" name="content" cols ="20" rows="3">${notice.noticeContent }</textarea></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${ notice.noticeDate}</td>

		</tr>
		<tr>
			<th>조회수</th>
			<td>${ notice.noticeHit}</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="공지수정">
			<input type="reset" value="초기화">
			<input type="button" value="삭제" onclick="deleteFnc(${notice.noticeId})">
		</tr>
	</tbody>
</table>
</form>