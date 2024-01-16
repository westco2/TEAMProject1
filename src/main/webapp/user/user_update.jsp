<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/header.jsp"%>



<div align="center" style="color: #7D4214;" class="div_center">
	<form action="updateFrom.user" method="post" style="text-align: center;">
		<table border="1" style="margin: 0 auto; text-align: left;">
			<h3 style="color: #885ea7">회원정보 수정 페이지</h3>
			<hr>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" value="${vo.id}" readonly>
				</td>
			</tr>

			<tr>
				<td>비밀번호</td>
					<td>
						<input type="password" name="pw" placeholder="비밀번호는 5자 이상 입력" required>
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" name="pw_check" placeholder="비밀번호는 5자 이상 입력" required>
					</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" value="${vo.name}">
				</td>
				
			</tr>
			<tr>
				<td>닉네임</td>
				<td>
					<input type="text" name="nickname" value="${vo.nick}">
				</td>
				
			</tr>

			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" value="${vo.email}" placeholder="ex) abc@def.com">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="address" value="${vo.address}" placeholder="ex) OO시 OO구">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="checkbox" name="gender" ${vo.gender == 'M' ? 'checked' : '' } value="M">남자
					<input type="checkbox" name="gender" ${vo.gender == 'F' ? 'checked' : '' } value="F">여자
				</td>
			</tr>
			
		</table>
		<br>
		
		<input type="submit" value="수정" class="btn btn-default"    style="color: #885ea7; background-color: #512772;" onclick="">&nbsp;&nbsp;
		<input type="button" value="취소" class="btn btn-default"  style="color: #885ea7; background-color: #512772;" onclick="location.href='/TEAMProject/main/index.jsp';">
		
	</form>






	