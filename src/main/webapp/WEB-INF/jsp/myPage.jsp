<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지 :: 카페코스테스</title>
    <style rel="stylesheet">
        html {
            width: 100%;
            height: 100%;
        }

        body {
            color: rgba(0, 0, 0, 0.6);
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .form-toggle {
            z-index: 10;
            position: absolute;
            top: 60px;
            right: 60px;
            background: #FFFFFF;
            width: 60px;
            height: 60px;
            border-radius: 100%;
            -webkit-transform-origin: center;
            -ms-transform-origin: center;
            transform-origin: center;
            -webkit-transform: translate(0, -25%) scale(0);
            -ms-transform: translate(0, -25%) scale(0);
            transform: translate(0, -25%) scale(0);
            opacity: 0;
            cursor: pointer;
            -webkit-transition: all 0.3s ease;
            transition: all 0.3s ease;
        }

        .form-group {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-flex-wrap: wrap;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
            -webkit-box-pack: justify;
            -webkit-justify-content: space-between;
            -ms-flex-pack: justify;
            justify-content: space-between;
            margin: 0 0 20px;
        }

        .form-group:last-child {
            margin: 0;
        }

        .form-group label {
            display: block;
            margin: 0 0 10px;
            color: rgba(0, 0, 0, 0.6);
            font-size: 12px;
            font-weight: 500;
            line-height: 1;
            text-transform: uppercase;
            letter-spacing: .2em;
        }

        .form-group input {
            outline: none;
            display: block;
            background: rgba(0, 0, 0, 0.1);
            width: 100%;
            border: 0;
            border-radius: 4px;
            box-sizing: border-box;
            padding: 12px 20px;
            color: rgba(0, 0, 0, 0.6);
            font-family: inherit;
            font-size: inherit;
            font-weight: 500;
            line-height: inherit;
            -webkit-transition: 0.3s ease;
            transition: 0.3s ease;
        }

        .form-group input:focus {
            color: rgba(0, 0, 0, 0.8);
        }

        .form-group button {
            outline: none;
            background: black;
            width: 100%;
            border: 0;
            border-radius: 4px;
            padding: 12px 20px;
            color: white;
            font-family: inherit;
            font-size: inherit;
            font-weight: 500;
            line-height: inherit;
            text-transform: uppercase;
            cursor: pointer;
            font-weight: 700;
        }

        .form-group .form-remember {
            font-size: 12px;
            font-weight: 400;
            letter-spacing: 0;
            text-transform: none;
        }

        .form-group .form-remember input[type='checkbox'] {
            display: inline-block;
            width: auto;
            margin: 0 10px 0 0;
        }

        .form-group .form-recovery {
            color: #4285F4;
            font-size: 12px;
            text-decoration: none;
        }

        .form-panel {
            padding: 60px calc(5% + 60px) 60px 60px;
            box-sizing: border-box;
        }


        .form-header h1 {
            padding: 4px 0;
            color: black;
            font-size: 24px;
            font-weight: 700;
            text-transform: uppercase;
        }


        .pen-footer a {
            color: #FFFFFF;
            font-size: 12px;
            text-decoration: none;
            text-shadow: 1px 2px 0 rgba(0, 0, 0, 0.1);
        }

    </style>
</head>
<body>
<% String redirect_url = request.getParameter("redirect_url"); %>
<%if(session.getAttribute("name")==null){ // 로그인 안되어있는상태라면 %>
<div class="form-panel one">
    <div class="form-header">
        <h1>로그인 하셔야 합니다.</h1>
    </div>
    <div class="form-group">
        <button style="text-align: center" onclick="location.href='home?pageName=User/login.jsp&redirect_url=/home?pageName=myPage.jsp'">로그인</button>
        <br>
        <br>
        <button style="text-align: center" onclick="location.href='home?pageName=Introduction/access_terms.jsp'">회원가입</button>

    </div>
</div>
<br>

<% }else { // 로그인이 되어있으면
%>
<div class="form-panel one">
    <br>
    보유하신 쿠폰의 개수는 <%=session.getAttribute("coupon")%>개 입니다.
    <div class="form-group">
    <button style="text-align: center" onclick="location.href='home?pageName=checkUser.jsp&redirect_url=/updateUserInfo'">회원정보수정</button>
    <button style="text-align: center" onclick="location.href='home?pageName=checkUser.jsp&redirect_url=/withDraw'">회원탈퇴</button>
    </div>
</div>


<%--<a href="/checkUser?redirect_url=updateUserInfo">회원정보수정</a>--%>
<%--<a href="/myCoupon">쿠폰내역</a>--%>
<%--<a href="/checkUser?redirect_url=withDraw">회원탈퇴</a>--%>
<%}%>

</body>
</html>
