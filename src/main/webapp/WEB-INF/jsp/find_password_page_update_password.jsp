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
<div class = "content_container">
<!-- 새로운 비밀번호를 입력하게 해주는곳 -->
<h1 style="text-align: center">비밀번호를 입력해주세요.</h1>
<form method="post" action="/request/findPasswordUpdate" id="form" onsubmit="return check()">
    <h5>비밀번호        </h5><input type="password" name="password1" placeholder="새로운 비밀번호">
    <h5>비밀번호 확인 :  </h5><input type="password" name="password2" placeholder="새로운 비밀번호 확인">
    <input type="hidden" name="user_num" id="user_num" value="<%=request.getParameter("user_num")%>">
    <br>
    <br>
    <input type="submit" value="비밀번호 변경">
</form>
</div>
</body>
<script>
    function check() {

        // 아이디 박스 아무것도 입력 안할경우
        var frm = document.getElementById("form");
        if(frm.password1.value == null || frm.password1.value == ""){
            alert("비밀번호를 입력해주세요.");
            // return 으로 false 를 해줌으로서 submit이 진행되지 않도록 해준다.
            return false;
        }
        if(frm.password2.value == null || frm.password2.value == ""){
            alert("비밀번호를 입력해주세요.");
            // return 으로 false 를 해줌으로서 submit이 진행되지 않도록 해준다.
            return false;
        }

        if(frm.password1.value != frm.password2.value){
            alert("비밀번호가 맞지 않습니다.");
            // return 으로 false 를 해줌으로서 submit이 진행되지 않도록 해준다.
            return false;
        }

        // 위 if 문에 해당사항이 없을경우 그대로 진행한다.
        return true;
    }


</script>

</html>
