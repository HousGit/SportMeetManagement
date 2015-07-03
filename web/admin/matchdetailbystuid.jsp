<%@ page import="java.util.List" %>
<%@ page import="cn.net.hous.games.Match" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/20
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Match> matches = Match.getMatchesByStuid(Integer.parseInt(request.getParameter("id")));
%>
<html>
<head>
    <title></title>
</head>
<body>
<h2 align="center">参赛情况</h2>
<table align="center" border="1">
    <tr>
        <td>比赛编号</td>
        <td>学号</td>
        <td>姓名</td>
        <td>比赛名称</td>
        <td>比赛分组</td>
    </tr>
    <%
        for (int i=0; i<matches.size(); i++){
            Match m = matches.get(i);
    %>
    <tr>
        <td><%=m.getMatchid()%></td>
        <td><%=m.getPlayer().getStudentid()%></td>
        <td><%=m.getPlayer().getPlayername()%></td>
        <td><%=m.getItem().getItemname()%></td>
        <td><%=m.getGroup()%></td>
    </tr>
    <%
        }
    %>
</table>
<h4 align="center"><a href="playerview.jsp">返回</a> </h4>
</body>
</html>
