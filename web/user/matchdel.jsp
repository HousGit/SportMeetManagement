<%@ page import="cn.net.hous.games.Match" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/20
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Match.delete(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("playercenter.jsp");
%>
</body>
</html>
