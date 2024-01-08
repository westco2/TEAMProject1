<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쪽지 작성</h3>
	<form action="writeForm.scripts" method="post" name="write_form">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="user_id" required></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="letter_detail" cols="22" rows="5" placeholder="200자이내" required></textarea></td>
			</tr>
			<tr>
				<td>받는사람</td>
				<td><input type="text" name="letter_send_id" required></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td><input type="date" name="letter_date"></td>
			</tr>		 			
		</table>
			<input type="submit" value="보내기">
			<input type="reset" value="초기화">
  	</form>
</body>
</html>