<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/7/2
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (null != request.getParameter("hidden")){
        if (request.getParameter("type").equals("stuname")){
            response.sendRedirect("scorebystuname.jsp?stuname="+request.getParameter("keyword"));
        }else if (request.getParameter("type").equals("stuid")){
            response.sendRedirect("scorebystuid.jsp?id="+request.getParameter("keyword"));
        }else if (request.getParameter("type").equals("itmid")){
            response.sendRedirect("scorebyitmid_q.jsp?id="+request.getParameter("keyword"));
        }
    }
%>
<html>
<head>
    <title></title>
</head>
<body>

<br>
<br>
<h2 align="center">搜索</h2>
<br>
<br>

<center>
    <form action="search.jsp"  method="post">
        <input type="hidden" name="hidden" value="hidden">
        <input type="text" name="keyword"  >
        <select name="type">
            <option value="stuid">按学号</option>
            <option value="stuname">按姓名</option>
            <option value="itmid">按项目</option>
        </select><br><br>
        <input type="submit" value="搜索">

    </form>
</center>
</body>
</html>
