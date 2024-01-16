<%@ page language="java"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/header.jsp" %>


<hr>
    <img src="${vo.path}" >


<hr>
<Strong style="color: #512772"><a>id:${vo.witer}</a>가격:${vo.price}</Strong>
<b style="color: #885ea7">지역:${vo.address}</b>
<c:choose>
<c:when test="${sessionScope.user_id != vo.witer}">
<form action = "write.scripts?writer=${vo.witer }" style="color: #885ea7; text-align: left" method = "post">
    <input type = "submit" name = "send" value = "쪽지 쓰기">
</form>
<input type ="button" value="찜하기" onclick="location.href='attention.post?pno=${vo.pno }';">
</c:when>
</c:choose>


<hr>
<h3>상품제목:${vo.title }</h3>

<br>
<h5 STYLE="color: black">내용: ${vo.content }</h5><br>

<hr>
<c:choose>
<c:when test="${sessionScope.user_id != vo.witer}">
<input type = "button" name = "review" value = "리뷰하기" onclick="" >
</c:when>
</c:choose>

<hr>
</table>




