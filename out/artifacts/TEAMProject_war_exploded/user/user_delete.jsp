<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/header.jsp"%>




	<div align="center" style="color: #7D4214;" class="div_center">
		<h3>현재 비밀번호를 입력하세요.</h3>
		<hr>

		<form action="deleteForm.user" method="post"> 
			비밀번호: <input type="password" name="pw">&nbsp;
			${msg }
			<input type="submit" value="확인" class="btn btn-default" style="color: #D3B49E; background-color: #7D4214;"> 
		</form>

	</div>
	
	
	