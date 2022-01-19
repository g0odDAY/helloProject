<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>공지 등록</h2>
<form action="${pageContext.request.contextPath}/noticeAdd.do" method="post">
	<table class="table">
		<thead>
			<tr>
				<th>공지제목</th>
				<td><input type="text" name="nTitle"></td>
			</tr>
			<tr>
				<th>공지내용</th>
				<td><textarea rows="4" cols="40" name="nContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="공지입력">
				<input type="reset" value="초기화">
				</td>
			</tr>
		</thead>
	
	
	
	</table>
	



</form>