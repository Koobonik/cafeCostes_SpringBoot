<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 :: 카페코스테스</title>
</head>
<body>
<% String redirect_url = request.getParameter("redirect_url"); %>
<%if(session.getAttribute("name")==null){ // 로그인 안되어있는상태라면 %>
<h1>로그인</h1>
<form action="/request/login" method="post">
    아이디 <input type= "text" name="id">
    비밀번호 <input type="password" name="pwd">
    <input type="hidden" name="redirect_url" value="home?pageName=myPage.jsp&redirect_url=/myPage">
    <input type="submit" value="로그인">
    <input type="button" value="회원가입" onclick="location.href = '/signup'">
</form>
<%--<%response.sendRedirect("/login?redirect_url="+redirect_url);%>--%>
<% }else { // 로그인이 되어있으면
%>
<h3>로그인되어있음</h3>
<%response.sendRedirect("/");%>
<%}%>

</body>
</html>
