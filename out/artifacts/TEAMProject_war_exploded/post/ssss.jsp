<%--
  Created by IntelliJ IDEA.
  User: westco2
  Date: 2024-01-09
  Time: 오전 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<div class="login-box">
	<link rel=stylesheet href=01.css>
	<h2>로그인</h2>
	<form>
		<div class="user-box">
			<input type="text" name="" required="">
			<label>아이디</label>
		</div>
		<div class="user-box">
			<input type="password" name="" required="">
			<label>비밀번호</label>
		</div>
		<a href="#">
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			로그인
		</a>
		<a href="#">
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			회원가입
		</a>
	</form>
</div>