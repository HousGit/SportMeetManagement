<%@ page import="java.util.List" %>
<%@ page import="cn.net.hous.games.Item" %>
<%@ page import="cn.net.hous.games.Score" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/7/2
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Integer> itmid = Item.getItemIds();
%>
<html>
<head>
    <title></title>
</head>
<body>
<h2 align="center">成绩列表</h2>


<%
    for (int j = 0; j < itmid.size(); j++) {
        List<Score> list = Score.getScoreByItmId(itmid.get(j), 3);

%>
<h3 align="center"><%=Item.getItemById(itmid.get(j)).getItemname()%>
</h3>
<table align="center" border="1">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>项目名称</td>
        <td>比赛分组</td>
        <td>项目成绩</td>
        <td>名次</td>
    </tr>
    <%
        for (int i = 0; i < list.size(); i++) {
            Score s = list.get(i);
    %>
    <tr>
        <td><%=s.getMatch().getPlayer().getStudentid()%>
        </td>
        <td><%=s.getMatch().getPlayer().getPlayername()%>
        </td>
        <td><%=s.getMatch().getItem().getItemname()%>
        </td>
        <td><%=s.getMatch().getGroup()%>
        </td>
        <td><%=s.getScore()%>
        </td>
        <td><%=i + 1%>
        </td>
    </tr>

    <%
        }
    %>
</table>
<%
        out.print("<br>");
    }
%>
</body>
</html>
