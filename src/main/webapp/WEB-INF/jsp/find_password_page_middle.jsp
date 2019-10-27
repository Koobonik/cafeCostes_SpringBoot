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
<% String fail = request.getParameter("fail"); %>
<script>
    if ("<%=fail%>" == "1"){
        alert("이름과 이메일이 맞지 않습니다.");
    }
</script>
<div class = "content_container">
<!-- 이메일로 인증코드 보내는 페이지 -->
    <h1 style="text-align: center">인증코드를 이메일로 보내드릴 예정입니다.</h1>
    <p>본인확인 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</p>
    <form method="post" action="/request/findPasswordEmail" id="form" onsubmit="return check()">
        <h5>이름 </h5><input type="text" name="name" placeholder="이름">
        <h5>이메일주소 </h5><input type="email" name="email"  placeholder="exam@abcd.com">
        <br>
        <br>
        <input type="submit" value="인증번호 전송">
    </form>
</div>
</body>
<script>
    function check() {

        // 아이디 박스 아무것도 입력 안할경우
        var frm = document.getElementById("form");
        if(frm.name.value == null || frm.name.value == ""){
            alert("이름을 입력해주세요.");
            // return 으로 false 를 해줌으로서 submit이 진행되지 않도록 해준다.
            return false;
        }

        // 사이즈 선택하지 않을경우
        if(frm.email_box.value == null || frm.email_box.value == ""){
            alert("이메일을 입력해주세요.");
            return false;
        }

        // 위 if 문에 해당사항이 없을경우 그대로 진행한다.
        return true;
    }


    function dreset() {
        // real 에는 bool 형식으로 변수가 담길 것이다.
        var real = confirm("정말로 다시 쓰시겠습니까?");
        // 예 버튼 누를 시 그대로 진행
        if (real == true){
            return true;
        }

        // 아니오 버튼 누를 시 취소
        else {
            return false;
        }

    }

</script>
</html>
