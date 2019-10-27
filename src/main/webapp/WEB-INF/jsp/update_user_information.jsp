<%@ page import="static java.awt.SystemColor.info" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>유저정보수정 :: 카페코스테스</title>
</head>
<body>
<%--${info.userName}--%>
<%--${info.userLoginId}--%>
<%--${info.userLoginPassword}--%>
<%--${info.userPhoneNumber}--%>
<%--${info.userEmail}--%>
<%--${real}--%>
<%
    String success = request.getParameter("success");
%>
<%if(session.getAttribute("name")==null){ // 로그인 안되어있는상태라면 %>
<%
    response.sendRedirect("/checkUser?login=no");
%>

<% } else { // 로그인이 되어있으면
%><script>
    if("${real}" == "true"){
        alert("성공적으로 변경되었습니다.");
    }
    </script><%
%>
<div class = "content_container">
    <h2>정보 수정후에는 갱신이 되지않는다면 로그아웃 후 재 로그인 해보시길 바랍니다.</h2>
    <br>
    <div style="background-color: aliceblue">
        <h3>이름 변경</h3>
        <form action="/request/updateUserInfoName" method="post">
            <input type="hidden" name="num" value=${info.userNum}>
            <input type="text" name="name" value="${info.userName}">
            <input type="submit" value="수정하기">
        </form>
    </div>


    <div style="background-color: cornflowerblue">
        <h3>연락처 변경</h3>
        <form action="/request/updateUserInfoPhone" method="post">
            <input type="hidden" name="num" value=${info.userNum}>
            <input type="number" name="phone" value="${info.userPhoneNumber}">
            <input type="submit" value="수정하기">
        </form>
    </div>

    <div style="background-color: darkslategrey">
        <h3>이메일 변경</h3>
        <form action="/request/updateUserInfoEmail" method="post">
            <input type="hidden" name="num" value=${info.userNum}>
            <input type="email" name="email" value="${info.userEmail}">
            <input type="submit" value="수정하기">
        </form>
    </div>

    <div style="background-color: sienna">
        <h3>비밀번호 변경</h3>
        <form action="/request/updateUserInfoLoginPassword" method="post" name="form" id="form">
            <input type="hidden" name="num" value=${info.userNum}>
            <input type="password" name="password1" value="">
            <br>
            <br>
            <input type="password" name="password2" value="">
            <input type="button" value="수정하기" onclick="check()">
        </form>
    </div>
</div>
<%}%>
<script>
    function check() {
        var form = document.getElementById("form");
        if (form.password1.value == "" || form.password1.value == null){
            alert("패스워드를 입력해주세요");
            return false;
        }
        if (form.password2.value == "" || form.password2.value == null){
            alert("패스워드를 입력해주세요");
            return false;
        }
        if (form.password1.value != form.password2.value){
            alert("두개의 비밀번호가 다릅니다.")
            return false;
        }
        document.getElementById('form').submit();
    }
    function printalert() {
        alert("성공적으로 변경되었습니다.");
    }
</script>
</body>
</html>
