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


<div >
    <h3 align="center" style="color: #7D4214;" class="div_center">인기</h3>

	<div class="container mt-3">
		<div class="row">
			<c:forEach var="i" items="${list}">
				<div class="col-md-3">
					<a href="sell.post?pno=${i.pno}" class="text-decoration-none">
						<div class="product card mb-3">
							<div class="thumbnail" style="background-image: url('${i.path}');"></div>
							<div class="card-body">
								<h5 class="title card-title">${i.title}</h5>
								<p class="date card-text"><fmt:formatDate value="${i.postDate}" pattern="YYYY.MM.dd" /></p>
								<p class="price card-text" style="font-weight: 800;">${i.price}</p>
								<p class="address card-text">${i.address}</p>
								<p class="card-text">조회수 ${i.hit} 찜 ${i.attention}</p>
							</div>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script>

	<div class="container mt-3">
		<form action="" class="form-inline">
			<div class="form-group">
				<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='write.post';">
			</div>
		</form>
	</div>

</div>