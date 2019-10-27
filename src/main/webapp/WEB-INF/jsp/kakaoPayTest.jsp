<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>카카오페이 테스트</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
<h1> kakaoPay api 이용하기 </h1>

<form method="post" action="/kakaoPay">
  <button>카카오페이로 테스트 결제하기</button>
</form>

<form method="post" action="/kakaoPay2">
    <input type="hidden" name="partner_user_id" value="kim">
    <input type="hidden" name="item_name" value="김승훈바보">
    <input type="hidden" name="total_amount" value="80000">
    <button>카카오페이로 결제하기</button>
</form>

</body>
</html>
