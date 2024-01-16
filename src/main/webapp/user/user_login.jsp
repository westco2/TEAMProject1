<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/header.jsp"%>



<div align="center" class="div_center">


	<h3 style="color: #885ea7">로그인페이지</h3>
	<hr>
	<form action="loginForm.user" method="post" >
		<input type="text" name="id" placeholder="아이디"><br><br>
		<input type="password" name="pw" placeholder="비밀번호"><br><br>
		<input type="submit" value="로그인" style="color: white; background-color: #512772;" class="btn btn-default" >&nbsp;&nbsp;
		<input type="button" value="회원가입" style="color: white; background-color: #512772;" class="btn btn-default" onclick="location.href='join.user';">
	</form>
	${msg }<br>


</div>





