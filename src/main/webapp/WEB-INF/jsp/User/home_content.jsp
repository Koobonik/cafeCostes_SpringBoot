<%--
  Created by IntelliJ IDEA.
  User: CS3-32
  Date: 2019-05-23
  Time: 오후 5:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.slider').bxSlider({
                auto: true,
                speed: 400,
                pause: 4000,
                mode: 'horizontal',
                autoControls: true,
                pager: true,
                captions: true,
            });
        })
    </script>

    <style>

        div {
            max-width: 100%;

        }

    </style>
</head>

<body>
<div>
    <ul class="slider">
        <li><img src="https://imgur.com/pcCzknw.jpg" >
        </li>
        <li><img
                src="https://imgur.com/p3ZC9nu.jpg" width = "100%" height = "90%">
        </li>
        <li><img
                src="https://imgur.com/x21n1us.jpg" height = "90%" width = "100%" >
        </li>
    </ul>
</div>


</body>
</html>