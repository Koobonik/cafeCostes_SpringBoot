<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<div id="map" style="width:500px;height:400px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e6a973ac41f600014da0bb22e466edec"></script>
<script>
    var container = document.getElementById('map');
    var options = {
        center: new daum.maps.LatLng(33.450701, 126.570667),
        level: 3
    };

    var map = new daum.maps.Map(container, options);
</script>
</body>
</html>
