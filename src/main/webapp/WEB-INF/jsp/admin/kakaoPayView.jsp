<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cafecostes.cafe.DB.KakaoPayPayment" %>
<%@ page import="java.util.ArrayList" %><%--
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
//            KakaoPayPayment kakaoPayPayment[] = (KakaoPayPayment[]) request.getAttribute("kakao");
//            out.print(kakaoPayPayment[0].getAid() + "ㅁㄴㅇㅁㄴㅇㅁㄴㅇ");
//            ArrayList<KakaoPayPayment> arrayList = (ArrayList<KakaoPayPayment>) request.getAttribute("kakao");
//            out.print(arrayList.size());
            
    %>


    <table border="1">
        <caption>카카오페이 결제 내역</caption>
        <thead>
        <tr>
            <th style="background-color: #757575">주문번호</th>
            <th style="background-color: #757575">이름</th>
            <th style="background-color: #757575">상품이름</th>
            <th style="background-color: #757575">결제금액</th>
            <th style="background-color: #757575">결제일시</th>
            <th style="background-color: #757575">결제수단</th>
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

        <c:forEach items="${kakao}" var="k">
            <tr>
            <td>${k.num}</td>
            <td>${k.partner_user_id}</td>
            <td>${k.item_name}</td>
            <td>${k.money}</td>
            <td>${k.approved_at}</td>
            <td>${k.payment_method_type}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <%
        }
    %>
</div>
</body>
</html>

