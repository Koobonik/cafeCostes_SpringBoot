<%@ page import="java.util.List" %>
<%@ page import="com.cafecostes.cafe.DB.Menu" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메뉴 :: 카페코스테스</title>
</head>
<body>
<h2> 카테고리별로 음료를 모았습니다. </h2>

<%--<%@include file="shopping.jsp"%>--%>


<jsp:include page="shopping.jsp" flush="false">
    <jsp:param name="type" value="A"/>
</jsp:include>
</body>
</html>
