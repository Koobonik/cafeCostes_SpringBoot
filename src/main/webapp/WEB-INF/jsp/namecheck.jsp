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
<script type="text/javascript">
    function setParentText(){
        opener.document.getElementById("pInputName").value = document.getElementById("cInputName").value;
        window.close();
    }

</script>


<% String id = request.getParameter("id"); %>
<%--<script>--%>
    <%--if ("<%=id%>" == "fail"){--%>
        <%--alert("사용 불가합니다.");--%>
    <%--}--%>
    <%--else if("<%=id%>" == "success" ){--%>
        <%--alert("사용 가능합니다.");--%>

    <%--}--%>
<%--</script>--%>
<%
  if (id.equals("fail")) {
      out.print("이미 사용중입니다.");
      %>
<input type="hidden" id="cInputName" value="cant">
<input type="button" value="닫기" onclick="window.close()">
<%
  }
  else if (id.equals("success")){
      out.print("사용 가능합니다.");
      %>
<input type="hidden" id="cInputName" value="can">
<input type="button" value="사용하기" onclick="setParentText()">
<%
  }
%>
 <%--<input type="button" value="전달하기" onclick="setParentText()">--%>

<%--<button onclick="window.close()">닫기</button>--%>
</body>
</html>
