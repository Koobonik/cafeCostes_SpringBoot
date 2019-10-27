<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 인증 :: 카페코스테스</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<% String login = request.getParameter("login");%>
<% String redirect_url = request.getParameter("redirect_url"); %>
<%-- 사용자가 맞는지 확인 하는 페이지 --%>
<%if(session.getAttribute("name")==null){ // 로그인 안되어있는상태라면 %>
<%response.sendRedirect("/myPage");%>

<% } else { // 로그인이 되어있으면
%>
<script>
    if("<%=login%>" == "no"){
        alert("인증에 실패하였습니다.");
    }
</script>
<%--<form action="home?pageName=update_user_information.jsp&redirect_url=/updateUserInfo" method="post">--%>
<form action="/request/reallyYou" method="post">
    <h3>아이디와 비밀번호를 한 번 더 입력해주세요.</h3>
    아이디 <input type= "text" name="id">
    비밀번호 <input type="password" name="pwd">
    <input type="hidden" name="redirect_url" value="<%=redirect_url%>">
    <input type="submit" value="인증">
    <%--<input type="button" value="회원가입" onclick="location.href = 'main.jsp?pagefile=join'">--%>
</form>
<%}%>
</body>
</html>
