<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="b" tagdir="/WEB-INF/tags/board"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/icon/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script>
	$(document).ready(function() {
		const appRoot = "${pageContext.request.contextPath}";
		
		// 현재 게시물의 댓글 목록 가져오기
		const listReply = function() {
			$("#replyListContainer").empty();
			$.ajax({
				url : appRoot + "/reply/board/${board.id}",
				success : function(list) {
					
					for (let i = 0; i < list.length; i++) {
						const replyMediaObject = $(`
							<hr>
							<div class="media">
							  <div class="media-body">
							    <h5 class="mt-0"><i class="far fa-comment"></i> \${list[i].nickName}가 \${list[i].customInserted}에 작성</h5>
								<p>\${list[i].reply}</p>
							   </div>
							</div>`);
						
						$("#replyListContainer").append(replyMediaObject);
					}
				}
			});
		}
		
		listReply(); // 페이지 로딩 후 댓글 리스트 가져오는 함수 한 번 실행
		
		// 댓글 전송
		$("#sendReply").click(function() {
			const reply = $("#replyTextarea").val();
			const memberId = "${sessionScope.loggedInMember.id}";
			const boardId = "${board.id}"
			
			const data = {
					reply : reply,
					memberId : memberId,
					boardId : boardId
			}
			
			$.ajax({
				url : appRoot + "/reply/write",
				type : "post",
				data : data,
				success : function() {
					// 댓글 리스트 새로고침
					listReply();
					
					// textarea 초기화
					$("#replyTextarea").val("");
				}
			});
		});
	});
</script>

<title>Insert title here</title>
</head>
<body>

	<b:navBar></b:navBar>

	<div class="container">
		<div class="row">
			<div class="col">
				<h1>게시물 조회</h1>

				<div class="board-view">
					<!-- .form-group*3>label[for=input$]+input.form-control#input$[readonly] -->
					<div class="form-group">
						<label for="input1">제목</label>
						<input type="text" class="form-control" id="input1" readonly value="${board.title }">
					</div>
					<div class="form-group">
						<label for="input2">내용</label>
						<!-- <input type="text" class="form-control" id="input2" readonly=""> -->
						<textarea class="form-control" id="input2" readonly>${board.content }</textarea>
					</div>
					<div class="form-group">
						<label for="input3">작성자</label>
						<input type="text" class="form-control" id="input3" readonly value="${board.nickName }">
					</div>

					<!-- a.btn.btn-outline-secondary>i.far.fa-edit -->
					<c:if test="${sessionScope.loggedInMember.id eq board.writer }">
						<a href="modify?id=${board.id }" class="btn btn-outline-secondary">
							수정/삭제
							<!-- <i class="far fa-edit"></i> -->
						</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${not empty sessionScope.loggedInMember }">
		<!-- 댓글 작성 textarea container -->
		<div class="container">
			<div class="row">
				<div class="col">
					<hr>
					<!-- .input-group>textarea#replyTextarea.form-control+.input-group-append>button.btn.btn-outline-secondary#sendReply -->
					<div class="input-group">
						<textarea name="" id="replyTextarea" class="form-control"></textarea>
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" id="sendReply">
								<i class="far fa-comment-dots"></i>
							</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	</c:if>

	<!-- 댓글 container -->
	<hr>

	<div class="container">
		<div class="row">
			<div class="col">
				<div id="replyListContainer"></div>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>