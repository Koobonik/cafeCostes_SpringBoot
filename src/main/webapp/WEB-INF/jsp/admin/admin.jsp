<%--
  Created by IntelliJ IDEA.
  User: 민철
  Date: 2019-06-03
  Time: 오전 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="user_interface">
    <%
        if(session.getAttribute("name").equals("koo")){
            out.print("관리자 로그인");
            out.print("<li><a onclick = \"location.href = 'home?pageName=admin/admin.jsp'\">관리자 페이지</a></li>");
    %>
    <form method="post" action="/request/kakaoPayView">
        <input type="submit" value="페이보여주기">
    </form>
    <tbody id="tbody">

    <!-- each posts 는 리스트를 순회하여 하나씩 꺼내어 각각의 필드값에 채워서 테이블에 출력시킴 -->

    </tbody>
    <%
        }
    %>
</div>
</body>
</html>

