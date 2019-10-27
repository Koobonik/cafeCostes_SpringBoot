<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style rel="stylesheet">
        .form-group input {
            outline: none;
            display: block;
            background: rgba(0, 0, 0, 0.1);
            width: 100%;
            border: 0;
            border-radius: 4px;
            box-sizing: border-box;
            padding: 12px 20px;
            color: rgba(0, 0, 0, 0.6);
            font-family: inherit;
            font-size: inherit;
            font-weight: 500;
            line-height: inherit;
            -webkit-transition: 0.3s ease;
            transition: 0.3s ease;
        }

        .form-group input:focus {
            color: rgba(0, 0, 0, 0.8);
        }

        .form-group button {
            outline: none;
            background: black;
            width: 100%;
            border: 0;
            border-radius: 4px;
            padding: 12px 20px;
            color: white;
            font-family: inherit;
            font-size: inherit;
            font-weight: 500;
            line-height: inherit;
            text-transform: uppercase;
            cursor: pointer;
            font-weight: 700;
        }
    </style>
</head>
<body>
<div class="form-group">
<%if(session.getAttribute("name")==null){ // 로그인 안되어있는상태라면 %>
<h4>로그인이 되어있지 않습니다.</h4>
<a href="/home?pageName=User/login.jsp&redirect_url=/">로그인</a>
<%--<h1>로그인</h1>--%>
<%--<form action="/request/login" method="post">--%>
    <%--아이디 <input type= "text" name="id">--%>
    <%--비밀번호 <input type="password" name="pwd">--%>
    <%--<input type="submit" value="로그인"> <input type="button" value="회원가입" onclick="location.href = '/signup'">--%>
<%--</form>--%>
<%--<%response.sendRedirect("/login?redirect_url="+redirect_url);%>--%>
<% }else { // 로그인이 되어있으면
%>
장바구니
<br>
<%=session.getAttribute("shopping_name")%> 님의 장바구니
<br>
상품목록 : <%=session.getAttribute("shopping_list")%>
<br>
상품개수 : <%=session.getAttribute("shopping_num")%>
<br>
상품가격 : <%=session.getAttribute("shopping_sum_cost")%>
<br>
<%--<%--%>
    <%--String list = session.getAttribute("shopping_list").toString(); // 상품 목록들 쭉 받아옴--%>
    <%--String list_array[] = list.split(", "); // 상품 스플릿--%>
    <%--String order_list; // 총 주문 목록들--%>
    <%--int quantity = (Integer.parseInt(session.getAttribute("shopping_num").toString()));--%>
    <%--// 0 개이거나 그거보다 작으면--%>
    <%--if (Integer.parseInt(session.getAttribute("shopping_num").toString()) <= 0){--%>
        <%--out.print("상품이 없습니다.");--%>
        <%--order_list = "null";--%>
    <%--}--%>
    <%--// 1개 일경우--%>
    <%--else if (Integer.parseInt(session.getAttribute("shopping_num").toString()) == 1) {--%>
        <%--out.print(list_array[0] + "1 잔");--%>
        <%--order_list = list;--%>
    <%--}--%>
    <%--// 1개 이상일 경우--%>
    <%--else {--%>
        <%--out.print(list_array[0] + " 외 " + (Integer.parseInt(session.getAttribute("shopping_num").toString()) - 1) + " 잔\n");--%>
        <%--order_list = list_array[0]  + " 외 " + (Integer.parseInt(session.getAttribute("shopping_num").toString()) -1) + " 개";--%>
        <%----%>
        <%----%>
<%--//        out.print("<br>");--%>
<%--//        out.print("배열 길이 " + list_array.length + "\n");--%>
<%--//        out.print("<br>");--%>
<%--//        int count = 0;--%>
<%--//        for (int i = 0; i < list_array.length; i++) {--%>
<%--//--%>
<%--//            // 마지막에 들어온 목록이랑 해당 배열 요소의 음료가 같다면? 텍스트를 줄이고 잔을 증가시켜줘야함--%>
<%--//            if (list_array[list_array.length - 1].equals(list_array[i])){--%>
<%--//                count++;--%>
<%--//            }--%>
<%--//        }--%>
        <%--//out.print(list_array[list_array.length - 1] + " " + count + "잔");--%>
        <%--// 결국 얘가 주문 목록에 표시될 변수--%>
        <%--// order_list = list;--%>
    <%--}--%>


<%--%>--%>
<%--<br>--%>

<%--<form method="post" action="/request/setShopping">--%>
    <%--<input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">--%>
    <%--<input type="hidden" name="list" value="아메리카노">--%>
    <%--<input type="hidden" name="num" value=<%=1%>>--%>
    <%--<input type="hidden" name="sum_cost" value=1500>--%>
    <%--<input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">--%>
    <%--<input type="submit" value="장바구니에 아메리카노 넣기">--%>
<%--</form>--%>
<%--<br>--%>

<%--<form method="post" action="/request/setShopping">--%>
    <%--<input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">--%>
    <%--<input type="hidden" name="list" value="카페라떼">--%>
    <%--<input type="hidden" name="num" value=<%=1%>>--%>
    <%--<input type="hidden" name="sum_cost" value=1500>--%>
    <%--<input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">--%>
    <%--<input type="submit" value="장바구니에 카페라떼 넣기">--%>
<%--</form>--%>

<%--<br>--%>

<form method="post" action="/kakaoPay" id="form2">
    <input type="hidden" name="partner_user_id" value="<%=session.getAttribute("shopping_name")%>">
    <%--<input type="hidden" name="item_name" value="<%=order_list%>">--%>
    <%--<input type="hidden" name="quantity" value="<%=quantity%>">--%>
    <input type="hidden" name="total_amount" value=<%=session.getAttribute("shopping_sum_cost")%>>
    <%--<button onclick="return check(form2)">카카오페이로 결제하기</button>--%>
    <button>카카오페이로 결제하기</button>
</form>
<br>

<form method="post" action="/request/removeShopping">
    <input type="hidden" name="userName" value="<%=session.getAttribute("shopping_name")%>">
    <input type="hidden" name="redirect_url" value="/home?pageName=Introduction/menu.jsp">
    <input type="submit" value="장바구니 비우기">
</form>

<%}%>
<script>
    function check(form2) {
        var h = document.getElementById("form2");
        if(h.item_name.value == "" || h.item_name.value == null || h.total_amount.value <= 0 || h.quantity.value <= 0 ){
            alert("값이 잘못되었습니다.");
            return false;
        }
        else {
            document.getElementById('form2').submit();
            return true
        }

    }
</script>
</div>
</body>
</html>
