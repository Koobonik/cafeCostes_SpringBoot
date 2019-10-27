<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>회원탈퇴 :: 카페코스테스</title>
</head>
<body>
<% String redirect_url = request.getParameter("redirect_rul"); %>
<div class = "content_container">
    <h1>회원 탈퇴하기</h1>
    <form method="post" action="reallyWithDraw" name="form" id="form">
        <input type="hidden" name="redirect_url" value="/withDrawSuccess">
        <input type="hidden" name="userLoginId" value=${info.userLoginId}>
        <input type="hidden" name="userLoginPassword" value=${info.userLoginPassword}>
        <input type="checkbox" name="reason" value="서비스 불친절"> 서비스 불친절
        <br>
        <input type="checkbox" name="reason" value="수많은 버그"> 수많은 버그
        <br>
        <input type="checkbox" name="reason" value="메뉴 부족"> 메뉴 부족
        <br>
        <input type="checkbox" name="reason" value="졸업으로 인한 미이용"> 졸업으로 인한 이용 제한
        <br>
        <input type="checkbox" name="reason" value="개인정보 보호를 위하여"> 개인정보 보호를 위하여
        <br>
        <input type="checkbox" name="reason" value="기타"> 기타
        <br>
        그 외 사유 <br><input type="text" name="reason" value="" width="450">
        <br>
        <br>
        <input type="button" value="탈퇴하기" onclick="really()">

    </form>
</div>
<script>
    function really() {
        var real = confirm("탈퇴를 진행하시면 쿠폰이 말소되며 복구가 진행되지 않습니다. 정말로 탈퇴 하시겠습니까?");
        if(real == true){
            document.getElementById('form').submit();
        }
    }
</script>
</body>
</html>
