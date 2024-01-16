<%@ page language="java"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html lang="ko">

<head>
    <title>연근마켓</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>  @import url(https://fonts.googleapis.com/css?family=Lato:400,300,700,900);  </style>
    <script src="https://kit.fontawesome.com/xxxxxxxxcxc.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        div{
            position:relative;
            padding: 2em;
            display:block;
            text-align:center;
            color: #512772
        }
        h1 {
            position: relative;
            display: inline;
            font-size: 200%;
            padding: 1em 0;
        }

        h1:before,
        h1:after{
            content:'`';

            position:absolute;
            left: -1.2ex;
            top: 0.2em;
            width: 1em;
            height: 1em;
            font-size:300%;
            -ms-transform: rotate(-40deg); /* IE 9 */
            -webkit-transform: rotate(-40deg); /* Chrome, Safari, Opera */
            transform: rotate(-40deg);}

        h1:after{
            left: auto;
            right: -1.2ex;
            top: -0.1em;
            -ms-transform: rotate(140deg); /* IE 9 */
            -webkit-transform: rotate(140deg); /* Chrome, Safari, Opera */
            transform: rotate(140deg);
        }





        *, *:after, *:before {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }

        a:hover, a:focus {
            outline: none;
        }


        h3 {
            color: #fff;
            font-weight: bold;
            margin: 0 0 50px 0;
            position: relative;
            padding: 0 0 5px 0;
        }

        h3:before {
            content: "";
            background:#885ea7;
            bottom: -4px;
            width: 25%;
            height: 1px;
            left: 0;
            position: absolute;
        }

        .back {
            padding: 1px 0 1px 0;
        }

        .color-1 {
            background: #885ea7;
        }

        .color-2 {
            background: #885ea7;
        }

        .color-3 {
            background: #885ea7;
        }






        body * {
            font-family: 'noto-serif kr-regular', "Noto Serif KR", serif !important;
        }

        /*
        -----------------
        common style
        -----------------
        */

        .row {
            display: flex;
            justify-content: space-between;
        }

        .menu {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .menu li {
            margin: 20px; /* 각 메뉴 항목 사이의 간격 설정 */
        }

        .menu a {
            color: rgba(255, 255, 255, 0.8);
            font-family: Lato;
            font-size: 17pt;
            font-weight: 400;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            text-decoration: none;
        }

        .SMN_effect-73 a {
            position: relative;
            overflow: hidden;
            padding: 0;
            padding-bottom: 5px;
        }

        .SMN_effect-73 a:after {
            background: #fff;
            content: '';
            height: 2px;
            top: 0;
            bottom: 0;
            margin: auto;
            left: 0;
            opacity: 0;
            position: absolute;
            transform: translate3d(-100%, 0, 0);
            width: 100%;
        }

        .SMN_effect-73 a:hover::after {
            animation: link-hoverstate .5s linear forwards;
            animation-timing-function: linear;
            animation-timing-function: cubic-bezier(0.645, 0.045, 0.355, 1);
        }

        @keyframes link-hoverstate {
            0% {
                opacity: 1;
                transform: translate3d(-100%, 0, 0)
            }
            55% {
                transform: translate3d(100%, 0, 0)
            }
            56% {
                transform: translate3d(100%, calc(0.5rem + 4px), 0)
            }
            100% {
                opacity: 1;
                transform: translate3d(0, calc(0.5rem + 4px), 0)
            }
        }
        .SMN_effect-3 a:after {
            position: absolute;
            top: 100%;
            left: 0;
            width: 100%;
            height: 1px;
            background: #fff;
            content: '';
            opacity: 0;
            -webkit-transition: height 0.3s, opacity 0.3s, -webkit-transform 0.3s;
            -moz-transition: height 0.3s, opacity 0.3s, -moz-transform 0.3s;
            transition: height 0.3s, opacity 0.3s, transform 0.3s;
            -webkit-transform: translateY(-10px);
            -moz-transform: translateY(-10px);
            transform: translateY(-10px);
        }

        .SMN_effect-3 a:hover:after, .SMN_effect-3 a:focus:after {
            height: 5px;
            opacity: 1;
            -webkit-transform: translateY(0px);
            -moz-transform: translateY(0px);
            transform: translateY(0px);
        }

        .login-box {
            display: flex;
            align-items: center; /* 세로 중앙 정렬 */
            margin-right: 40px; /* 오른쪽 여백 조절 */
        }

        .login-box h2 {
            margin: 20px; /* 기본 마진 제거 */
            font-size: 20px; /* 폰트 크기 조절 */
        }

        html {
            height: 100%;
        }
        body {
            margin: 20px;
            font-family: 'Arial', sans-serif;
            background:  white;
            color: #fff;
        }



        .login-box {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 400px;
            padding: 40px;
            transform: translate(-50%, -50%);
            background: rgba(0, 0, 0, .5);
            box-sizing: border-box;
            box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
            border-radius: 10px;
        }

        .login-box h2 {
            margin: 0 0 30px;
            padding: 0;
            color: #fff;
            text-align: center;
        }

        .login-box .user-box {
            position: relative;
        }

        .login-box .user-box input {
            width: 100%;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            margin-bottom: 30px;
            border: none;
            border-bottom: 1px solid #fff;
            outline: none;
            background: transparent;
        }

        .login-box .user-box label {
            position: absolute;
            top: 0;
            left: 0;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            pointer-events: none;
            transition: .5s;
        }

        .login-box .user-box input:focus~label,
        .login-box .user-box input:valid~label {
            top: -20px;
            left: 0;
            color: white;
            font-size: 12px;
        }

        .login-box form a {
            position: relative;
            display: inline-block;
            padding: 10px 20px;
            color: white;
            font-size: 16px;
            text-decoration: none;
            text-transform: uppercase;
            overflow: hidden;
            transition: .5s;
            margin-top: 40px;
            letter-spacing: 4px;
        }

        .login-box a:hover {
            background: white;
            color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 5px #69368f, 0 0 25px #69368f, 0 0 50px #69368f, 0 0 100px #69368f;
        }

        .login-box a span {
            position: absolute;
            display: block;
        }

        .login-box a span:nth-child(1) {
            top: 0;
            left: -100%;
            width: 100%;
            height: 2px;
            background: linear-gradient(90deg, transparent, #b69acb);
            animation: btn-anim1 1s linear infinite;
        }

        @keyframes btn-anim1 {
            0% {
                left: -100%;
            }

            50%, 100% {
                left: 100%;
            }
        }

        .login-box a span:nth-child(2) {
            top: -100%;
            right: 0;
            width: 2px;
            height: 100%;
            background: linear-gradient(180deg, transparent, #b69acb);
            animation: btn-anim2 1s linear infinite;
            animation-delay: .25s
        }

        @keyframes btn-anim2 {
            0% {
                top: -100%;
            }

            50%, 100% {
                top: 100%;
            }
        }

        .login-box a span:nth-child(3) {
            bottom: 0;
            right: -100%;
            width: 100%;
            height: 2px;
            background: linear-gradient(270deg, transparent, #b69acb);
            animation: btn-anim3 1s linear infinite;
            animation-delay: .5s
        }

        @keyframes btn-anim3 {
            0% {
                right: -100%;
            }

            50%, 100% {
                right: 100%;
            }
        }

        .login-box a span:nth-child(4) {
            bottom: -100%;
            left: 0;
            width: 2px;
            height: 100%;
            background: linear-gradient(360deg, transparent, #b69acb);
            animation: btn-anim4 1s linear infinite;
            animation-delay: .75s
        }

        .div_center {
            color: #7D4214;
            text-align: center;
            font-family: 'Arial', sans-serif;
            /* Change the font-family as needed */
        }

        .container {
            margin-top: 20px;
        }

        .row {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .col-md-4 {
            margin-bottom: 20px;
        }

        .product {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: rgba(0, 0, 0, 0.5);
            border-radius: 10px;
            padding: 10px;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.6);
            transition: transform 0.3s ease-in-out;
        }

        .product:hover {
            transform: scale(1.05);
        }

        .thumbnail {
            width: 100%;
            height: 200px;
            background-size: cover;
            background-position: center center;
            margin-bottom: 10px;
            border-radius: 5px;
        }

        .title {
            color: #fff;
            font-size: 1.2em;
            margin-bottom: 5px;
        }

        .card-text {
            color: #fff;
            font-size: 0.9em;
        }

        .btn-default {
            color: #D3B49E;
            background-color: #7D4214;
            border-color: #7D4214;
        }

        .btn-default:hover {
            background-color: #D3B49E;
            color: #7D4214;
        }

        .form-inline {
            margin-top: 20px;
        }
        .table-bordered {
            border: 2px solid #7D4214;
            color: #7D4214;
        }

        th,
        td {
            text-align: center;
        }
        .custom-box {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        body {
            margin: 20px;
            font-family: 'Arial', sans-serif;
            background: white;
            color: #fff;
        }

        .login-box2,
        .message-box,
        .note-box {
            width: 48%;
            padding: 20px;
            background: rgba(0, 0, 0, .5);
            box-sizing: border-box;
            box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
            border-radius: 10px;
            color: #fff;
        }

        .div_center {
            text-align: center;
        }

        .table-bordered {
            border: 2px solid #7D4214;
            color: #7D4214;
            width: 100%;
        }
        div[align="center"].div_center {
            margin-top: 20px; /* 로고 위쪽 마진 추가 */
        }

        /* 기존 스타일 유지 */

        nav.navbar {
            margin-bottom: 20px; /* 하단바 아래쪽 마진 추가 */
        }
        th,
        td {
            text-align: center;
        }

        .custom-box {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        h3 {
            color: #7D4214;
        }

        .btn-custom {
            background-color: #7D4214;
            color: #D3B49E;
            border: none;
            margin-top: 20px;
        }

        .btn-custom:hover {
            background-color: #D3B49E;
            color: #7D4214;
        }

        textarea {
            resize: none;
        }
        .login-box2 h2 {
            margin: 20px; /* 기본 마진 제거 */
            font-size: 20px; /* 폰트 크기 조절 */
        }
    </style>
</head>
<body>

<div style="display: flex; justify-content: flex-end; padding: 10px;">
    <c:choose>
        <c:when test="${sessionScope.user_id == null}">
            <a href="login.user" style="text-decoration: none; color: inherit;">
                <b style="color: #885ea7">로그인</b> &nbsp; &nbsp;
            </a>
            <a href="join.user" style="text-decoration: none; color: inherit;">
                <b style="color: #885ea7">회원가입</b>
            </a>
        </c:when>
        <c:otherwise>
            <a href="logout.user" style="text-decoration: none; color: inherit;">
                <b style="color: #885ea7">로그아웃</b> &nbsp; &nbsp;
            </a>
            <a href="mypage.user" style="text-decoration: none; color: inherit;">
                <b style="color: #885ea7">마이연근</b>
            </a>
        </c:otherwise>
    </c:choose>
</div>

<div style="padding: 10px">
    <link rel="stylesheet" href="02.css">
    <a href="/main/index.jsp" style="text-decoration: none; color: inherit;">
        <h1>yeongeun</h1>
    </a>
</div>

<div class="back color-3">
    <div class="row columns">
        <ul class="menu align-center expanded text-center SMN_effect-73">
            <div class="btn-group">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                    카테고리
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <li STYLE="color: cornflowerblue"><a class="dropdown-item" href="category.post?category=패션/의류&sort=pno">패션/의류</a></li>
                    <li><a class="dropdown-item" href="category.post?category=리빙/가전&sort=pno">리빙/가전</a></li>
                    <li><a class="dropdown-item" href="category.post?category=식품&sort=pno">식품</a></li>
                    <li><a class="dropdown-item" href="category.post?category=문구/생활용품&sort=pno">문구/생활용품</a></li>
                    <li><a class="dropdown-item" href="category.post?category=PC/핸드폰&sort=pno">PC/핸드폰</a></li>
                    <li><a class="dropdown-item" href="category.post?category=기타&sort=pno">기타</a></li>
                </ul>
            </div>
            <li><a href="pop.post">인기매물</a></li>
            <li><a href="list.post">중고거래</a></li>
            <div class="search-container"></div>
            <form action="search.post?sort=pno" method="post" accept-charset="UTF-8">
                <input type="search" style="text-align: center;" class="search-box" placeholder="검색어를 입력하세요" name="search">
                <button class="search-btn" type="submit">검색</button>
            </form>
            <svg xmlns="http://www.w3.org/2000/svg" height="20" width="20" viewBox="0 0 512 512">
                <path fill="#B197FC" d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z"></path>
            </svg>
        </ul>
    </div>
</div>




