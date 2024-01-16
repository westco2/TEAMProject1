<%@ page language="java"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<body>
<div class="div_center">
	<div class="custom-box">
		<div class="message-box">
			<h3>쪽지 보기</h3>
			<hr>
			<table class="table table-bordered">
				<tr>
					<td width="20%">글번호</td>
					<td width="30%">${vo.bno}</td>

					<td width="20%">받는사람</td>
					<td width="30%">${vo.letter_send_id}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${vo.user_id}</td>

					<td>작성일</td>
					<td>${vo.letter_date}</td>
				</tr>
				<tr>
					<td width="20%">글내용</td>
					<td colspan="3" height="120px">${vo.letter_detail}</td>
				</tr>
			</table>
			<input type="button" value="삭제" onclick="location.href='deleteForm.scripts?bno=${vo.bno}';"
				   class="btn btn-custom">
			<input type="button" value="목록" onclick="location.href='listForm.scripts?bno=${vo.bno}';"
				   class="btn btn-custom">
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>

