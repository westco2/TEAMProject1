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
    <h3 align="center" style="color: #7D4214;" class="div_center">중고거래</h3>

    <c:forEach var="i" items="${list}">
    	<c:choose>
    		<c:when test="${i.pno !=  null}">
        		<div class="container mt-3">
        			<a href ="sell.post?pno=${i.pno}">
            			<div class="product">
							<div class="thumbnail" style="background-image: url('${i.path}'); background-size: 350px 350px"></div>
                			<div class="flex-grow-1 p-4">
                
                    		<h5 class="title">${i.title}</h5>
                    		<p class="date"><fmt:formatDate value="${i.postDate}" pattern="YYYY.MM.dd" /></p>
                    		<p class="price">${i.price}</p>
                    		<p class="address">${i.address}</p>
                    		<p class="float-end">조회수${i.hit}</p>
                    		<p class="float-end">찜${i.attention}</p>
                			</div>
            			</div>
        			</a>
       			</div>
       		</c:when>
       		<c:otherwise>
       		
       		</c:otherwise>	
        </c:choose>
    
    </c:forEach>
        <form action="" class="form-inline" >
            <div class="form-group">
                <input type="text" name="search" placeholder="제목검색" class="form-control" style="text-align: center">
                <input type="submit" value="검색" class="btn btn-default">
                <input type="button" value="글 작성" class="btn btn-default" onclick="location.href='write.post';">
            </div>
        </form>

</div>

</html>
