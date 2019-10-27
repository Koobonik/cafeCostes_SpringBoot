<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>코스테스 :: 게시판</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<% String board = request.getParameter("board"); %>
<script>
    if("<%=board%>" == "fail"){
        alert("없는 게시글 입니다.");
    }
</script>
<div class="content_body" style="margin : 30px">
    <table border="1">
        <caption>게시판</caption>
        <thead>
        <tr>
            <th style="background-color: #757575">게시판 번호</th>
            <th style="background-color: #757575">제목</th>
            <th style="background-color: #757575">작성자</th>
            <th style="background-color: #757575">조회수</th>
            <th style="background-color: #757575">추천</th>
        </tr>
        </thead>
        <tfoot>
        <%--<tr>--%>
        <%--<th>합</th>--%>
        <%--<th>225</th>--%>
        <%--<th>230</th>--%>
        <%--</tr>--%>
        </tfoot>
        <tbody>

        <c:forEach items="${board}" var="k">
            <tr>
                <td>${k.id}</td>
                <td><a href="home?pageName=board_view.jsp&boardView=${k.id}">${k.title}</a></td>
                <td>${k.userName}</td>
                <td>${k.boardCount}</td>
                <td>${k.likes}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <% if (session.getAttribute("name") != null)  { // 로그인이 잘 되어 있다면
    %>
    <button style="width: 60px; height: 30px"  onclick="location.href = 'home?pageName=board_write.jsp'">글쓰기</button>

    <%}%>
</div>
</body>
</html>
