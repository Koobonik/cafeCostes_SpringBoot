<%--
  Created by IntelliJ IDEA.
  User: 민철
  Date: 2019-06-02
  Time: 오후 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>
    <style rel="stylesheet">
        html {
            width: 100%;
            height: 100%;
        }

        body {
            color: rgba(0, 0, 0, 0.6);
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .form-toggle {
            z-index: 10;
            position: absolute;
            top: 60px;
            right: 60px;
            background: #FFFFFF;
            width: 60px;
            height: 60px;
            border-radius: 100%;
            -webkit-transform-origin: center;
            -ms-transform-origin: center;
            transform-origin: center;
            -webkit-transform: translate(0, -25%) scale(0);
            -ms-transform: translate(0, -25%) scale(0);
            transform: translate(0, -25%) scale(0);
            opacity: 0;
            cursor: pointer;
            -webkit-transition: all 0.3s ease;
            transition: all 0.3s ease;
        }

        .form-group {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-flex-wrap: wrap;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
            -webkit-box-pack: justify;
            -webkit-justify-content: space-between;
            -ms-flex-pack: justify;
            justify-content: space-between;
            margin: 0 0 20px;
        }

        .form-group:last-child {
            margin: 0;
        }

        .form-group label {
            display: block;
            margin: 0 0 10px;
            color: rgba(0, 0, 0, 0.6);
            font-size: 12px;
            font-weight: 500;
            line-height: 1;
            text-transform: uppercase;
            letter-spacing: .2em;
        }

        .form-group input {
            outline: none;
            display: block;
            background: rgba(0, 0, 0, 0.1);
            width: 100%;
            border: 0;
            border-radius: 4px;
            box-sizing: border-box;
            padding: 12px 20px;
            color: rgba(0, 0, 0, 0.6);
            font-family: inherit;
            font-size: inherit;
            font-weight: 500;
            line-height: inherit;
            -webkit-transition: 0.3s ease;
            transition: 0.3s ease;
        }

        .form-group input:focus {
            color: rgba(0, 0, 0, 0.8);
        }

        .form-group button {
            outline: none;
            background: black;
            width: 100%;
            border: 0;
            border-radius: 4px;
            padding: 12px 20px;
            color: white;
            font-family: inherit;
            font-size: inherit;
            font-weight: 500;
            line-height: inherit;
            text-transform: uppercase;
            cursor: pointer;
            font-weight: 700;
        }

        .form-group .form-remember {
            font-size: 12px;
            font-weight: 400;
            letter-spacing: 0;
            text-transform: none;
        }

        .form-group .form-remember input[type='checkbox'] {
            display: inline-block;
            width: auto;
            margin: 0 10px 0 0;
        }

        .form-group .form-recovery {
            color: #4285F4;
            font-size: 12px;
            text-decoration: none;
        }

        .form-panel {
            padding: 60px calc(5% + 60px) 60px 60px;
            box-sizing: border-box;
        }


        .form-header h1 {
            padding: 4px 0;
            color: black;
            font-size: 24px;
            font-weight: 700;
            text-transform: uppercase;
        }


        .pen-footer a {
            color: #FFFFFF;
            font-size: 12px;
            text-decoration: none;
            text-shadow: 1px 2px 0 rgba(0, 0, 0, 0.1);
        }

    </style>

    <script type = "text/javascript">

        var name = document.getElementById("name");




        function password_check(){
            var first_pw = document.getElementById("password1").value;
            var second_pw = document.getElementById("password2").value;
        }   alert(first_pw)


        if(first_pw != second_pw) {
            alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
            return false;
        }


    </script>
</head>
<body>


<div class="form" style = "border : 4px solid whitesmoke; margin : 20px 20px 20px 20px">
    <div class="form-toggle"></div>
    <div class="form-panel one">
        <div class="form-header">
            <h1>Join Membership</h1>
        </div>
        <%--회원가입 이루어지는 곳--%>
        <div class="form-panel two">
            <div class="form-header">
                <h1>Register Account</h1>
            </div>
            <div class="form-content">
                <form method="post" action="/request/signup" id="form">

                    <div class="form-group">
                        <label for="userLoginId">아이디</label>
                        <input type="text" id="userLoginId" name="userLoginId" required="required"/>
                        <button type="button" style="width: 200px" onclick="openChild(userLoginId)">중복 확인</button>
                    </div>

                    <div class="form-group">
                        <label for="userLoginPassword1">비밀번호</label>
                        <input type="password" id="userLoginPassword1" name="userLoginPassword1" required="required"/>
                    </div>

                    <div class="form-group">
                        <label for="userLoginPassword2">비밀번호 확인</label>
                        <input type="password" id="userLoginPassword2" name="userLoginPassword2" required="required"/>
                    </div>

                    <div class="form-group">
                        <label for="userName">이름 또는 별명</label>
                        <input type="text" id="userName" name="userName" required="required"/>
                        <button type="button" style="width: 200px" onclick="openChildName(userName)">중복 확인</button>
                    </div>

                    <div class="form-group">
                        <label for="userName">이메일 주소</label>
                        <br>
                        <button type="button" onclick="openChildEmail()">이메일 인증하기</button>
                    </div>

                    <div class="form-group">
                        <label for="userPhoneNumber">전화번호</label>
                        <input type="text" id="userPhoneNumber" name="userPhoneNumber" required="required"/>
                    </div>

                    <div class="form-group">
                        <label for="userPhoneNumber">성별</label>
                        <label>
                            <input type="radio" name="gender" value="남" checked>남자
                            <input type="radio" name="gender" value="여" >여자
                        </label>
                    </div>

                    <div class="form-group">
                        <label for="userPhoneNumber">나이</label>
                        <input type="number" name="age" required="required"/>
                    </div>
                    <input type="hidden" name="coupon" value=0>
                    <input type="hidden" name="datetime" value="">
                    <input type="hidden" id="userEmail" name="userEmail" value="">
                    <div class="form-group">
                        <button type="submit" onclick="return check()">회원가입</button>
                    </div>
                </form>

                <%--<input type="button" value="자식창 열기" onclick="openChild(userLoginId)"><br>--%>
                <input type="hidden" id="pInput" name="pInput">
                <input type="hidden" id="pInput" name="pInputName">
                <input type="hidden" id="pEmail" name="pEmail">
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        var panelOne = $('.form-panel.two').height(),
            panelTwo = $('.form-panel.two')[0].scrollHeight;

        $('.form-panel.two').not('.form-panel.two.active').on('click', function(e) {
            e.preventDefault();

            $('.form-toggle').addClass('visible');
            $('.form-panel.one').addClass('hidden');
            $('.form-panel.two').addClass('active');
            $('.form').animate({
                'height': panelTwo
            }, 200);
        });

        $('.form-toggle').on('click', function(e) {
            e.preventDefault();
            $(this).removeClass('visible');
            $('.form-panel.one').removeClass('hidden');
            $('.form-panel.two').removeClass('active');
            $('.form').animate({
                'height': panelOne
            }, 200);
        });
    });
</script>
<script>
    var openWin;
    function check() {
        var userEmail = document.getElementById("userEmail").value;
        var can = document.getElementById("pInput");
        var namecan = document.getElementById("pInputName");
        var email = document.getElementById("pEmail");

        if (userEmail == "" || userEmail == null){
            alert("이메일 인증을 해주세요.");
            return false;
        }

        // 사용가능이 아니라면
        if (can.value != "can"){
            alert("아이디 중복확인을 해주세요.");
            return false;
        }

        if (namecan.value != "can"){
            alert("이름 중복확인을 해주세요.");
            return false;
        }
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

        if(email.value != "can"){
            alert("이메일 인증을 해주세요.");
            return false;
        }
        document.getElementById('form').submit();
        // 위 if 문에 해당사항이 없을경우 그대로 진행한다.
        return true;
    }
    function idcheck(id) {
        var cid = id.value;
        openWin = window.open("/request/idcheck?id=" + cid,"","width=500,height=200,left=2000");

    }
    function openChild(id) { // window.name = "부모창 이름";
        var cid = id.value;
        window.name = "parentForm"; // window.open("open할 window", "자식창 이름", "팝업창 옵션")
        // window.open("Child.html", "childForm", "width=570, height=350, resizable = no, scrollbars = no");
        window.open("/request/idcheck?id=" + cid,"","width=500,height=200,left=2000");
    }
    function openChildName(name) { // window.name = "부모창 이름";
        var cid = name.value;
        //alert(cid);
        window.name = "parentForm"; // window.open("open할 window", "자식창 이름", "팝업창 옵션")
        // window.open("Child.html", "childForm", "width=570, height=350, resizable = no, scrollbars = no");
        window.open("/request/namecheck?name=" + cid,"","width=500,height=200,left=2000");
    }
    function setChildText() {

    }
    function openChildEmail() { // window.name = "부모창 이름";
        window.name = "parentForm"; // window.open("open할 window", "자식창 이름", "팝업창 옵션")
        // window.open("Child.html", "childForm", "width=570, height=350, resizable = no, scrollbars = no");
        window.open("/emailcheck","","width=500,height=200,left=2000");
    }



</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</body>
</html>

