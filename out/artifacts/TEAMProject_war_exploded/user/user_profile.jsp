<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<%
ArrayList<String> list = new ArrayList<>();

String r1 = "홍길동님: 좋은물건 싸게 샀습니다";
String r2 = "이순신님 :상품 설명이 좋아요!";
String r3 = "홍길자님 :너무 친절하셨습니다!";

list.add(r1);
list.add(r2);
list.add(r3);

String a1 = list.get(0);
String a2 = list.get(1);
String a3 = list.get(2);

%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- controller 에서 일어나야 할 구문 -->
	<!-- else if(path.equals("profileForm.user")){} -->
	<!-- userVO vo 를 받아와야한다. -->
	<!-- 리뷰를 ArrayList<review> list 형식으로 받아오기 -->
	
	<!-- 아래는 선택사항입니다 지워도 상관없음 -->
	
	<!-- HttpSession session=request.getSession; -->
	<!-- String user_id=(String)session.getAtrribute("user_id"); -->
	<!-- request.setAtrribute("user_id",user_id) -->
	<!-- request.getRequestDispatcher("user_profile.jsp").forward(request,response); -->
	 
</head> 
<body>

  <div style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
    <table>
        <tr>
            <td><img alt="프로필 이미지" src="../img/1111.webp" style="width: 50px; height: 50px;"></td>
            <td><input type="text" value="${vo.user_nick} 님" readonly></td>
        </tr>
    </table>
    <hr>
    <label for="email">email:</label>
    <input type="text" value="${vo.user_email}" readonly><br>
    <form action="#">
    <input type="submit" value="쪽지하기" style="color: #D3B49E; background-color: #7D4214;">
    </form>
    <hr>
    <h3>리뷰:</h3>
    <h5><%=a1 %></h5>
    <h5><%=a2 %></h5>
    <h5><%=a3 %></h5>
</div>
</body>
</html>