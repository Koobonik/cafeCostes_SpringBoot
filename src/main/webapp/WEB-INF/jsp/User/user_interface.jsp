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
    <ul>
        <%if(session.getAttribute("name")==null){ // 로그인 안되어있는상태라면 %>

        <li><a onclick="location.href = 'home?pageName=Introduction/access_terms.jsp'">JOIN</a></li>
        <li><a onclick = "location.href = 'home?pageName=User/login.jsp&redirect_url=/'">LOGIN</a></li>
                <% }else { // 로그인이 되어있으면
            if(session.getAttribute("name").equals("koo")){
                out.print("관리자 로그인");
                out.print("<li><a onclick = \"location.href = 'home?pageName=admin/admin.jsp'\">관리자 페이지</a></li>");
            }
        %>
            <h4><%=session.getAttribute("name")%> 님 반갑습니다.</h4>
            <h4>보유 쿠폰 개수 <%=session.getAttribute("coupon")%></h4>
        <li><a onclick = "location.href = '/logout?redirect_url=/'">LOGOUT</a></li>
                    <%}%>
        <li><a href = "/home?pageName=myPage.jsp&redirect_url=/myPage">MY PAGE</a></li>
        <li><a href = "/home">HOME</a></li>
    </ul>
</div>
</body>
</html>

