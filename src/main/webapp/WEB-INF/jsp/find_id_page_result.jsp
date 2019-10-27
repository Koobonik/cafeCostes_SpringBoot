<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<div class = "content_container">

    <h4>${name} 님의 로그인 아이디 입니다.</h4>
    ${id}
    <h3>바로 로그인 하고 싶다면?</h3>
    <form action="/request/login" method="post">
        아이디 <input type= "text" name="id" value="${id}">
        <br>
        <br>
        비밀번호 <input type="password" name="pwd">
        <br>
        <br>
        <input type="hidden" name="redirect_url" value="/">
        <input type="submit" value="로그인">
    </form>
    <a href="#">비밀번호가 기억나지 않으십니까?</a>
</div>
</body>
</html>
