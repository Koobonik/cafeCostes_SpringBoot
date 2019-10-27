<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>성서인의 쉼터 :: 카페코스테스</title>
</head>
<body>
    <h1 style="text-align: center">Hello world!</h1>

    <%if(session.getAttribute("name")==null){ // 로그인 안되어있는상태라면 %>
    <form action="/login" method="get">
        <input type="hidden" name="redirect_url" value="/">
        <input type="submit" value="로그인">
        <%--<input type="button" value="회원가입" onclick="location.href = 'main.jsp?pagefile=join'">--%>
    </form>
    <% } else { // 로그인이 되어있으면
    %>
    <form action="/logout" method="post" >
        <input type="hidden" name="redirect_url" value="/">
        <input type="submit" value="로그아웃">
    </form>
    <br>
    <h2><%= session.getAttribute("name") %>님 반갑습니다!</h2>
    <%}%>
    <br>
    <a style="text-align: center" href="/kakaoPayTest">카카오페이 테스트하기</a>
    <a href="/findID">아이디 찾기 로직</a>
    <a href="/findPassword">비밀번호 찾기 로직</a>
    <a href="/myPage">마이페이지</a>
    <a href="/buy">구매하기</a>
    <a href="/menu">메뉴보기</a>
    <a href="/signup">회원가입</a>

</body>
</html>
