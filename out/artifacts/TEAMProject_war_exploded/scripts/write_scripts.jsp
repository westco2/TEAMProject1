<%@ page language="java"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="div_center">
	<div class="custom-box">
		<div class="note-box">
			<h3>쪽지 작성</h3>
			<form action="writeForm.scripts" method="post" name="write_form">
				<table>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="user_id" value="${sessionScope.user_id }" readonly></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="letter_detail" cols="22" rows="5" placeholder="200자이내"
									  required></textarea></td>
					</tr>
					<tr>
						<td>받는사람</td>
						<td><input type="text" name="letter_send_id" required value="${writer }"></td>
					</tr>
				</table>
				<input type="submit" value="보내기" class="btn btn-custom">
				<input type="reset" value="초기화" class="btn btn-custom">
			</form>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>

</html>