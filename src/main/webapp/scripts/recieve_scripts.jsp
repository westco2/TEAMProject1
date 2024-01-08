<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>받은 쪽지</h3>
	<form>
		<table>
			<tr>
				<td>보낸이</td>
				<td><input type="text" name="user_id" value="${requestScope.user_id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>받는이</td>
				<td><input type="text" name="letter_send_id" value="${requestScope.Letter_send_id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>일자</td>
				<td><input type="text" name="letter_date" value="${requestScope.Letter_date}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="letter_detail" value="${requestScope.letter_detail}" readonly="readonly"></td>
			</tr>					
		</table>
			<input type="button" value="닫기" onclick="location.href='/';">
	</form>

</body>
</html>