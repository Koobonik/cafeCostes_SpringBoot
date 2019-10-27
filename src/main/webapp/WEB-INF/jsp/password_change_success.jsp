<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기 성공 :: 카페코스테스</title>
</head>
<body onload="setTimeout('nextWin()', 5000)">
<h3>비밀번호가 성공적으로 변경되었습니다.</h3>
<h3>5초 후 메인페이지로 이동됩니다..</h3>

</body>
<script type="text/javascript">
    //<![CDATA[
    function nextWin() {
        window.location.href = '/';
    }
</script>
</html>
