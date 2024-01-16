<%@ page language="java"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@ include file="../include/header.jsp"%>
<body>

<div class="message-box">
	<h3>쪽지 관리함</h3>
	<table class="table table-bordered">
		<thead>
		<tr>
			<th>글번호</th>
			<th>보낸이</th>
			<th>받는이</th>
			<th>시간</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="a" items="${list}">
			<tr>
				<td><a href="content.scripts?bno=${a.bno}">${a.bno}</a></td>
				<td><a href="write.scripts?writer=${a.user_id}">${a.user_id}</a></td>
				<td>${a.letter_send_id}</td>
				<td><fmt:formatDate value="${a.letter_date}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" value="쪽지쓰기" onclick="location.href='write.scripts';" class="btn btn-custom">
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>

</html>