<%--
  Created by IntelliJ IDEA.
  User: CS3-32
  Date: 2019-05-14
  Time: 오전 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" info ="Costes"%>
<html>
<head>

  <link rel ="stylesheet" href = "style.css?ver=1" >
  <meta name = "author" content = "mincheol">
  <meta name ="keywords" content ="cafe 홈페이지 제작">

  <title><%=getServletInfo()%></title>
  <style>


  </style>
</head>
<body onload = "javascript:window_onload()">
<script language="JavaScript">
    function window_onload(){
        setTimeout(url(),2000)
    }
    function url() {
        location.href = "/home"
    }
</script>

<div class="img" >

  <div class="content">
    <h1>사랑을 로스팅합니다.</h1>
  </div>
  <div class="img-cover"></div>
</div>

</body>
</html>