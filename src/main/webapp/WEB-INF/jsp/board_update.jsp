<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<% String board = request.getParameter("board"); %>

<% if (session.getAttribute("name") != null)  { // 로그인이 잘 되어 있다면
    %>

<form method="post" action="/request/updatePosts">
    제목 : <input type="text" name="title" value="${board.title}">
    <br>
    내용 :
    <br>
    <textarea name="content" cols="40" rows="10" autofocus required wrap="hard">${board.content}</textarea>
    <br>
    <input type="hidden" name="userName" value="${board.userName}">
    <input type="hidden" name="id" value="${board.id}">
    <input type="submit" value="수정">
</form>

<%} else {
    out.print("<script>alert(\"세션이 만료 되었습니다.\");</script>");
    %>
<script>location.href='/home?pageName=board.jsp';</script>
<%

}

%>
</body>
</html>
