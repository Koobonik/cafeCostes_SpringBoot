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
<% String fail = request.getParameter("fail"); %>
<script>
    if("<%=code%>" == "2"){
        alert("사용 불가한 코드 입니다. 다시 신청해주세요.");
    }
    else if("<%=code%>" == "3"){
        alert("인증시간을 초과하였습니다. 다시 신청해주세요.");
    }
    if ("<%=fail%>" == "1"){
        alert("맞는 아이디가 없습니다.");
    }
</script>
<div class = "content_container">
    <h1 style="text-align: center">아이디를 입력해주세요</h1>
    <form method="post" action="/request/findPassword" id="form" onsubmit="return check()">
        <h5>아이디 </h5><input type="text" name="id_box" placeholder="아이디">
        <input type="submit" value="다음">
    </form>

</div>
</body>
<script>
    function check() {

        // 아이디 박스 아무것도 입력 안할경우
        var frm = document.getElementById("form");
        if(frm.id_box.value == null || frm.id_box.value == ""){
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
