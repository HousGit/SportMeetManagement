<%@ page import="cn.net.hous.games.Player" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/17
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Player.playerDel(Integer.parseInt(request.getParameter("studentid")));
    response.sendRedirect("playerview.jsp");
%>
</body>
</html>
