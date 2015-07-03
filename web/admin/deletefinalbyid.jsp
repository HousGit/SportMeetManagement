<%@ page import="cn.net.hous.games.Match" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/7/2
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Match.deleteFinalById(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("matchdetailbyitmid.jsp?id="+request.getParameter("id"));

%>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
