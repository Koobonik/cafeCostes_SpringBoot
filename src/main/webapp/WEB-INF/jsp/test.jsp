<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<html><head>
    <title>JDBC ����̹� �׽�Ʈ</title>
</head>
<body>
<%
    Connection conn =null;
    Boolean connect =false;
    try {
        String jdbcUrl="jdbc:mysql://localhost:3306/db?serverTimezone=Asia/Seoul&useSSL=false"; //���� pc�� ��ġ �Ǿ��ִ� mysql�� ����
        String dbId="root"; //��� ID
        String dbPass="qhsdlr20"; // ��� �н�����
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection(jdbcUrl,dbId,dbPass);
        connect=true;
        conn.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    if(connect==true){
        out.print("����Ǿ����ϴ�");
    }else {
        out.print("���ῡ �����Ͽ����ϴ�.");
    }
%>
</body>
</html>