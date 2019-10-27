<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>코스테스 :: 게시판 보기</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<script>
    if("<%=request.getParameter("already")%>" == "1"){
        alert("이미 추천하였습니다.");
    }
    else if ("<%=request.getParameter("already")%>" == "2"){
        alert("추천하였습니다.");
    }
</script>
<table border="1">
    <caption>상세보기</caption>
    <thead>
    <tr>
        <th style="background-color: #757575">제목 : ${board.title} | 작성일 : ${board.datetime}</th>
    </tr>
    </thead>
    <tfoot>
        <tr>
            <th style="background-color: #757575"> 조회수 : ${board.boardCount} | 추천수 : ${board.likes}
                <form action="/request/likesPosts" method="post">
                    <input type="hidden" name="pageName" value="board_view.jsp">
                    <input type="hidden" name="boardView" value="${board.id}">
                    <input type="submit" value="추천!">

                </form>


            </th>
        </tr>
    </tfoot>
    <tbody>

    <tr>
        <td>${board.content}</td>
    </tr>
    </tbody>
</table>
<script>
    if("<%=session.getAttribute("name")%>" == "${board.userName}"){
        // alert("세션이랑 유저 이름 같음 본인 게시글임.");
        document.write("<form action='/request/removePosts' id='form' name='form' method='post'>");
        document.write("<input type='hidden' name='id' value='${board.id}'>");
        document.write("<button onclick='confirm2()'>삭제</button>");
        document.write("</form>");

        document.write("<form action='/boardUpdate' id='form2' name='form2' method='post'>");
        document.write("<input type='hidden' name='id' value='${board.id}'>");
        document.write("<input type='hidden' name='title' value='${board.title}'>");
        document.write("<input type='hidden' name='content' value='${board.content}'>");
        document.write("<input type='hidden' name='userName' value='${board.userName}'>");
        document.write("<button onclick='document.getElementById('form2').submit();'>수정</button>");
        document.write("</form>");

    }
</script>
<script>
    function confirm2() {
        var c = confirm("정말로 삭제 하시겠습니까?");
        if(c == true){
            document.getElementById('form').submit();
        }
        else {
            return false;
        }
    }
    function sub() {
        document.getElementById('form2').submit();
    }
</script>
</body>
</html>
