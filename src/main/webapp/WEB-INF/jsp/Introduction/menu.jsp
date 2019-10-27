<%--
  Created by IntelliJ IDEA.
  User: CS3-32
  Date: 2019-05-28
  Time: 오후 7:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table {
            width: 60%;
            height: auto;
            transform: translate(-30%, 0%);
            text-align: center;
        }

        .content_body td {
            width: 3%;
            height: 3%;
            font-family: "Arial";
            color: #848484;
            font-size: 15px;
        }

        .content_body tr {
            width: 3%;
            height: 3%;

        }

        .content_body th {
            width: 2%;
            background-color: black;
            color : white;
            text-align: center;
        }

        .menu_wrapper {
            width: 100%;
            height: 50%;
        }

        .menu_wrapper img {
            margin-top: 10px;
            max-width: 100%;
            height: 100%;
            width: 100%;
        }


    </style>
</head>
<body>

<div class="content_container">


    <div class="menu_wrapper">
        <img src="https://wikidocs.net/images/page/37661/%E1%84%8F%E1%85%A9%E1%86%AF%E1%84%83%E1%85%B3%E1%84%87%E1%85%B3%E1%84%85%E1%85%AE%E1%84%8B%E1%85%A9%E1%86%AB%E1%84%83%E1%85%A5%E1%84%85%E1%85%A1%E1%86%A8.JPG"
        >
    </div>
    <div class="content_header" style="text-align: left;">
        <h1> MENU </h1>
    </div>
    <div class="content_body" style="margin : 30px">


        <table>

            <tr>
                <th rowspan="4"><strong>SIGNATURE MENU</strong></th>
            </tr>
            <td><strong>흑당 버블티</strong></td>

            <td><strong>흑당 빙수</strong></td>

            <td><strong>콘소메 빙수</strong></td>
            <tr>

                <td><a onclick="location.href = '#'"><img
                        src="https://wikidocs.net/images/page/37660/%ED%9D%91%EB%8B%B9%EB%9D%BC%EB%96%BC.JPG"
                        hegiht=100% width=100%></a></td>

                <td><a onclick="location.href = '#'"><img
                        src="https://wikidocs.net/images/page/40708/%ED%9D%91%EB%8B%B9%EB%B9%99%EC%88%98.JPG"
                        hegiht=100% width=100%></a></td>
                <td><a onclick="location.href = '#'"><img
                        src="https://wikidocs.net/images/page/40708/%EC%BD%98%EC%86%8C%EB%A9%94%EB%B9%99%EC%88%98.JPG"
                        hegiht=100% width=100%></a></td>

            </tr>


            <tr>
                <td>3,000원 <form method="post" action="/request/setShopping">
                    <input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">
                    <input type="hidden" name="list" value="흑당 버블티">
                    <input type="hidden" name="num" value=<%=1%>>
                    <input type="hidden" name="sum_cost" value=3000>
                    <input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">
                    <input type="submit" value="담기">
                </form> </td>
                <td>3,500원 <form method="post" action="/request/setShopping">
                    <input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">
                    <input type="hidden" name="list" value="흑당 빙수">
                    <input type="hidden" name="num" value=<%=1%>>
                    <input type="hidden" name="sum_cost" value=3500>
                    <input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">
                    <input type="submit" value="담기">
                </form></td>
                <td>3,500원<form method="post" action="/request/setShopping">
                    <input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">
                    <input type="hidden" name="list" value="콘소메 빙수">
                    <input type="hidden" name="num" value=<%=1%>>
                    <input type="hidden" name="sum_cost" value=1500>
                    <input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">
                    <input type="submit" value="담기">
                </form></td>
            </tr>

<%--                        구분선                          --%>

            <tr>
                <th rowspan="4"><strong>LATTE</strong></th>
            </tr>
            <td><strong>초콜릿 라떼</strong></td>

            <td><strong>그린티 라떼</strong></td>

            <td><strong>고구마 라떼</strong></td>
            <tr>

                <td><a onclick="location.href = '#'"><img
                        src="https://wikidocs.net/images/page/37660/%EC%B4%88%EC%BD%9C%EB%A6%BF%EB%9D%BC%EB%96%BC.JPG"
                        hegiht=100% width=100%></a></td>

                <td><a onclick="location.href = '#'"><img
                        src="https://wikidocs.net/images/page/37660/%EA%B7%B8%EB%A6%B0%ED%8B%B0%EB%9D%BC%EB%96%BC.JPG"
                        hegiht=100% width=100%></a></td>
                <td><a onclick="location.href = '#'"><img
                        src="https://wikidocs.net/images/page/37660/%EA%B3%A0%EA%B5%AC%EB%A7%88%EB%9D%BC%EB%96%BC.JPG"
                        hegiht=100% width=100%></a></td>

            </tr>


            <tr>
                <td>2,000원 <form method="post" action="/request/setShopping">
                    <input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">
                    <input type="hidden" name="list" value="초코티 라떼">
                    <input type="hidden" name="num" value=<%=1%>>
                    <input type="hidden" name="sum_cost" value=2000>
                    <input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">
                    <input type="submit" value="담기">
                </form></td>
                <td>2,500원<form method="post" action="/request/setShopping">
                    <input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">
                    <input type="hidden" name="list" value="그린티 라떼">
                    <input type="hidden" name="num" value=<%=1%>>
                    <input type="hidden" name="sum_cost" value=2500>
                    <input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">
                    <input type="submit" value="담기">
                </form></td>
                <td>2,500원<form method="post" action="/request/setShopping">
                    <input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">
                    <input type="hidden" name="list" value="고구마 라떼">
                    <input type="hidden" name="num" value=<%=1%>>
                    <input type="hidden" name="sum_cost" value=2500>
                    <input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">
                    <input type="submit" value="담기">
                </form></td>
            </tr>

        </table>
    </div>

</div>
</body>
</html>

