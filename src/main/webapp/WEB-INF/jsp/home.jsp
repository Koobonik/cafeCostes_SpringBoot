<%--
  Created by IntelliJ IDEA.
  User: CS3-32
  Date: 2019-05-14
  Time: 오전 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" info ="Costes"%>
<%
    String pageName = request.getParameter("pageName");
    String interfaceName = request.getParameter("interfaceName");
    if (pageName == null){
        pageName = "Introduction/home_content.jsp";
    }

    if (interfaceName == null){
        interfaceName = "User/user_interface.jsp";
    }


%>
<jsp:forward page="template.jsp">
    <jsp:param name = "pageName" value = "<%=pageName%>"></jsp:param>
    <jsp:param name = "interfaceName" value="<%=interfaceName%>"></jsp:param>
</jsp:forward>
