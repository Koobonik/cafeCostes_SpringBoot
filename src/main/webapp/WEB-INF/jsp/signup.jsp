<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h6>회원가입 페이지 입니다.</h6>
<form method="post" action="/request/signup" id="form" onsubmit="return check()">
    <h5>로그인 아이디 :  </h5><input type="text" name="userLoginId" placeholder="ID">
    <h5>비밀번호         </h5><input type="password" name="userLoginPassword1" placeholder="새로운 비밀번호">
    <h5>비밀번호 확인 :  </h5><input type="password" name="userLoginPassword2" placeholder="새로운 비밀번호 확인">
    <h5>이름          :  </h5><input type="text" name="userName" placeholder="이름">
    <h5>이메일        :  </h5><input type="email" name="userEmail" placeholder="abcd@exam.com">
    <h5>전화번호      :  </h5><input type="number" name="userPhoneNumber" placeholder="010-1234-5678">
    <h5>성별</h5>
    <label>
        <input type="radio" name="gender" value="남" checked>남자
        <input type="radio" name="gender" value="여">여자
    </label>
    <h5>나이          :  </h5><input type="number" name="age">
    <input type="hidden" name="coupon" value=0>
    <input type="hidden" name="datetime" value="">
    <input type="submit" value="회원가입">
</form>
<script>
    function check() {

        // 아이디 박스 아무것도 입력 안할경우
        var frm = document.getElementById("form");
        if(frm.userLoginPassword1.value == null || frm.userLoginPassword1.value == ""){
            alert("비밀번호를 입력해주세요.");
            // return 으로 false 를 해줌으로서 submit이 진행되지 않도록 해준다.
            return false;
        }
        if(frm.userLoginPassword2.value == null || frm.userLoginPassword2.value == ""){
            alert("비밀번호를 입력해주세요.");
            // return 으로 false 를 해줌으로서 submit이 진행되지 않도록 해준다.
            return false;
        }

        if(frm.userLoginPassword1.value != frm.userLoginPassword2.value){
            alert("비밀번호가 맞지 않습니다.");
            // return 으로 false 를 해줌으로서 submit이 진행되지 않도록 해준다.
            return false;
        }

        // 위 if 문에 해당사항이 없을경우 그대로 진행한다.
        return true;
    }


</script>
</body>
</html>
