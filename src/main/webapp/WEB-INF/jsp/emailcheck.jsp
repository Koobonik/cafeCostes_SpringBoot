<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<script type="text/javascript">
    function setParentText(){
        //userEmail
        opener.document.getElementById("userEmail").value = document.getElementById("email").value;
        document.getElementById('form').submit();
    }

</script>


<%--//<% String email = request.getParameter("email"); %>--%>
<h3>이메일을 입력해주세요.</h3>
<form method="post" action="/request/emailAuth" id="form" name="form">
    <input type="email" name="email" id="email" placeholder="abcd@exam.com">
    <button type="button" onclick="setParentText()" value="전송">전송</button>
</form>




 <%--<input type="button" value="전달하기" onclick="setParentText()">--%>

<%--<button onclick="window.close()">닫기</button>--%>
</body>
</html>
