<%@ page import="cn.net.hous.games.Item" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/19
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Item.itemDel(Integer.parseInt(request.getParameter("itemid")));
    response.sendRedirect("itemview.jsp");
%>
</body>
</html>
