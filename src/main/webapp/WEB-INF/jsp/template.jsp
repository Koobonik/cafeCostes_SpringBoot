<%@ page import="javax.print.DocFlavor" %><%--
  Created by IntelliJ IDEA.
  User: CS3-32
  Date: 2019-05-14
  Time: 오전 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" info="Costes" %>
<%
    String pageName = request.getParameter("pageName");
    String interfaceName = request.getParameter("interfaceName");

%>

<html>
<head>
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <link rel="stylesheet" href="style.css?after">
    <meta name="author" content="Mincheol">
    <meta name="keywords" content="cafe 홈페이지 제작">
    <title><%=getServletInfo()%>
    </title>

    <style>
        a:link {
            color: #848484;
            text-decoration: none;
        }

        a:visited {
            color: #848484;
            text-decoration: none;
        }

        a:hover {
            color: #848484;
            text-decoration: underline;
        }
    </style>

</head>
<body>
<div class="container">
    <!-- header 부분-->
    <div class="header">


        <div class="header_left">
            <a onclick="location.href = 'home?pageName=Introduction/home_content.jsp'"><img src="https://imgur.com/dSq2P4m.jpg"
                                                                                                        width="130" height="130"
                                                                                                        style="border-radius: 100px; -moz-border-radius: 1010px;-khtml-border-radius: 100px; -webkit-border-radius: 100px;"></a>
        </div>

        <div class="header_right">
            <jsp:include page="<%=interfaceName%>"/>
            <div class="header_nav">
                <ul class="menu">
                    <li><a onclick="location.href = 'home?pageName=Introduction/company_introduction.jsp'">ABOUT</a>
                    </li>
                    <li><a onclick="location.href = 'home?pageName=Introduction/menu.jsp'">MENU</a></li>
                    <li><a onclick="location.href = 'home?pageName=Introduction/directions.jsp'">STORE</a>
                    </li>
                </ul>
            </div>
            <!-- 로그인 성공시 넘기기 -->

        </div>
    </div>


    <!-- content 부분-->

    <div class="content">
        <jsp:include page="<%=pageName%>"/>
        <!--value 값으로 page include-->
    </div>

    <!-- sidebar 부분 -->
    <div class="sidebar_container" >
        <div class="sidebar_container_left">
            <div class="sidebar_container_left_content">
                <i class="fas fa-angle-double-right" style="margin-left: -1.0em; margin-right: 0.5em;"></i>
                공지사항
            </div>
            <div class="sidebar_container_left_text_box">
                <marquee direction=up scrollamount=1>방학기간에도 Open 하는데.. 안올꾸야..?</marquee>
            </div>
        </div>
        <div class="sidebar_container_right">
            <div class="sidebar_container_right_content">
                <a href="home?pageName=board.jsp">최근 게시판 이동하기</a>
            </div>
            <i class="fas fa-comment-dots" style="margin-left: -1.0em; margin-right: 0.5em;"></i>
        </div>
    </div>


    <!-- footer 부분 -->
    <div class="footer" , oncontextmenu='return false' ondragstart='return false' onselectstart='return false'>
        <p>
            <jsp:include page="Introduction/footer.jsp"></jsp:include>
        </p>
    </div>
</div>
<div class=sharing_container>
    <jsp:include page = "shopping.jsp"/>
</div>
</body>
</html>
