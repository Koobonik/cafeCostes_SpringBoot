<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/htmlcharset=utf-8"/>
    <meta name="viewport" content="user-scalabel=no, initial-sacle=1.0, maximum-sacle=1.0, minimum-scale=1.0, width=device-width" />
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .a {

            display: inline-block;

            width: 200px;

            height: 200px;

            background-color: rgb(238, 232, 198);

        }

        .b {

            display: inline-block;

            width: 200px;

            height: 200px;

            background-color: blue;

        }

        .c {

            display: inline-block;

            width: 200px;

            height: 200px;

            background-color: black;

        }

        @media screen and (max-width: 700px) {

            .a, .b, .c {

                width: 100%;

            }

        }
    </style>
</head>
<%--<body onload="setTimeout('nextWin()', 5000)">--%>
<body style="background-color: rgb(238, 232, 198)">
<%--<div class="content_container">--%>
<div class="a" style="text-align: center">
    <br/>
    결제일시:     ${info.approved_at}
    <br/>
    주문번호:    ${info.partner_order_id}
    <br/>
    상품명:    ${info.item_name}
    <br/>
    상품수량:    ${info.quantity}
    <br/>
    결제금액:    ${info.amount.total}
    <br/>
    결제방법:    ${info.payment_method_type}
    <br/>
    정상적으로 결제가 이루어졌습니다.
    <br>
    평균 음료 제조 시간은 5분이지만
    <br>
    매장 상황에 따라 최대 10분 정도 소요될 수 있습니다.
    <br>
    <img src="https://i.imgur.com/9XZ3WBP.png">
    <%--<script type="text/javascript">--%>
        <%--//<![CDATA[--%>
        <%--function nextWin() {--%>
            <%--window.location.href = 'https://cafecostes.com/sendToCustomer?userName=${users}&token=${token}';--%>
        <%--}--%>
    <%--</script>--%>
</div>
</body>
</html>
