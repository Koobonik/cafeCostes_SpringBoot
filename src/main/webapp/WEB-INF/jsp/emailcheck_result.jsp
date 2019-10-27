<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<% String code = request.getParameter("code"); %>
<script>
    if("<%=code%>" == "1"){
        alert("등록되지 않은 코드 입니다. 코드를 확인 후 다시 입력해주세요.")
    }
</script>
<div class = "content_container">
<!-- 유저가 이메일로 받은 인증코드를 복사해서 여기다가 붙여넣기 한다. -->
    <h1 style="text-align: center">인증코드가 발송되었습니다.</h1>
    <p>이메일에서 확인한 인증코드를 입력해주세요.</p>
    <form method="post" action="/request/signupEmailAuth" id="form" onsubmit="return check()">
        <h5>인증코드 </h5><input type="text" name="auth_code" placeholder="8자리 코드">
        <input type="submit" value="인증코드 입력">
    </form>
</div>
</body>
<script>
    function check() {

        // 아이디 박스 아무것도 입력 안할경우
        var frm = document.getElementById("form");
        if(frm.auth_code.value == null || frm.auth_code.value == ""){
            alert("인증코드를 입력해주세요.");
            // return 으로 false 를 해줌으로서 submit이 진행되지 않도록 해준다.
            return false;
        }

        // 위 if 문에 해당사항이 없을경우 그대로 진행한다.
        return true;
    }






</script>
</html>
