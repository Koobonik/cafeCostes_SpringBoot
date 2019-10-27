<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기 성공 :: 카페코스테스</title>
</head>
<% String real = request.getParameter("real"); %>

<script>
    if("<%=real%>" == "false"){
        alert("탈퇴에 문제가 발생하였습니다.\n" + "kbi960130@bible.ac.kr 로 문의 바랍니다.");
        window.location.href = "/myPage";
    }
</script>
<body>

</body>

<body onload="setTimeout('nextWin()', 5000)">
<h3>탈퇴가 성공적으로 이루어졌습니다.</h3>
<h3>이용해주셔서 감사했습니다!</h3>
<h3>5초 후 메인페이지로 이동됩니다..</h3>

</body>
<script type="text/javascript">
    //<![CDATA[
    function nextWin() {
        window.location.href = '/';
    }
</script>
</html>
