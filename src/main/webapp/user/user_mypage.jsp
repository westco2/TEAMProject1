<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/header.jsp"%>



<div align="center" class="div_center">
	<h3 style="color: #512772;">MY PAGE</h3>
	<hr>
	<p>
		${sessionScope.user_id }<b style="color: #512772;">(${sessionScope.user_name })</b>님의 정보를 관리합니다.
	</p>

	<a href="update.user" style="color: #512772;">[회원 정보 변경]</a>&nbsp;&nbsp;
	<a href="delete.user" style="color: #512772;">[회원 탈퇴]</a>
</div>

<div align="center" class="div_center">
	<a href="my.post" style="color: white; background-color: #512772;" class="btn-custom">내 게시글</a>
	<a href="my_attention.post" style="color: white; background-color: #512772;" class="btn-custom">내 찜목록</a>
	<a href="listForm.scripts" style="color: white; background-color: #512772;" class="btn-custom">쪽지함</a>
</div>

    

	