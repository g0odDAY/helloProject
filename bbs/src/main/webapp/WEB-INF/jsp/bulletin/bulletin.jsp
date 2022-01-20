<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- ${bulletin } --%>
<script>
function deleteFnc(id){
	console.log("delete")
	document.forms.delFrm.id.value= id;
	document.forms.delFrm.submit();
}
</script>
<form name="delFrm"
	action="${pageContext.request.contextPath }/bulletinDelete.do"
	method="post">
	<input type="hidden" name="id">
</form>
<form id="detailFrm" action="${pageContext.request.contextPath }/bulletinUpdate.do"
	method="post">
	<input type="hidden" name="id" value="${bulletin.bbsId }">
	<table class='table' border="1">
		<tbody>
			<tr>
				<th>글번호</th>
				<td>${bulletin.bbsId }/ 작성자 : ${bulletin.bbsWriter }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input class="form-control" type="text" name="title"
					value="${bulletin.bbsTitle }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea class="form-control" name="content" cols="20"
						rows="3">${bulletin.bbsContent }</textarea></td>
			</tr>

			<tr>
				<th>작성일시</th>
				<td>${bulletin.bbsCreateDate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${bulletin.bbsHit }</td>
			</tr>
			<tr>
				<td colspan="2">
				<c:choose>
					<c:when test="${bulletin.bbsWriter == sessionId}">
					<input type="submit" value="수정">
					 <input
					type="reset" value="초기화">
					 <input type="button" value="삭제"
					onclick="deleteFnc(${bulletin.bbsId})">
					</c:when>
					<c:otherwise>
					<input type="submit" value="수정" disabled>
					<a href="${pageContext.request.contextPath }/bulletinList.do">글목록으로</a>
					</c:otherwise>
					
				</c:choose>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<style>
	div.row{
border:dotted 1px red;

	}
</style>
<div class="reply">
<div class="reply-list">

</div>
<div class="reply-register">
	<div>작성자:
		<span id="writer">${sessionId }</span>
	</div>
	<div>
		<textarea cols="40" rows="5" id="content"></textarea>
	</div>
	<div>
		<button id="register">등록</button>
	</div>
</div>
</div>
<script>
	//console.log(($('.reply-list')).children().eq(1).children().eq(0).text());
	//Ajax호출(댓글정보:원본글에 대한 1)
	let bbsId=$('#detailFrm>input[name="id"]').val();
	$.ajax({
		url:'replySelect.do',
		data:{id:bbsId},
		success:function(result){
			result.forEach(function(reply){
				attachList(reply);
			});	
		},
		error:function(){
			console.log(err);
		}
	});
	//데이터 한건을 가지고 리스트에 추가
	function attachList(reply){
		let div = $('<div>').attr('class','row').attr('id',reply.replyId);
		div.append(
		$('<span>').text(reply.replyWriter),
		
		$('<span>').text(reply.replyContent),
		$('<span>').text(reply.replyDate),
		$('<button>').text('댓글삭제').click(deleteReply)
		);
		$('.reply-list').append(div);
		function deleteReply(){
			let delId=$(this).parent().attr('id');
			console.log(delId);
			$.ajax({
				url:'replyDelete.do',
				data:{id:delId},
				dataType:'json',
				success:function(result){
					if(result.retCode == 'Success'){
						$('#'+delId).remove();
					}else{
						alert("댓글"+delId+"번 삭제 실패");
					}
				},
				error:function(err){
					console.log(err);
				}
			});
		}
	}
	//등록기능
	$('#register').on('click',function(){
		let bbsId=$('#detailFrm>input[name="id"]').val();
		let writer = $('#writer').text();
		let content = $('#content').val();
		$.ajax({
			url:'replyRegister.do',
			data:{bbsId: bbsId,writer: writer, content:content},
			success:function(result){
				console.log(result);
			},
			error: function(error){
				console.log(error);
				
			}
		});
	});
</script>