<%@ page import="java.util.List" %>
<%@ page import="cn.net.hous.games.Score" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/7/2
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Score> list = Score.getScores();
%>
<html>
<head>
    <title></title>
</head>
<body>
<h2 align="center">成绩列表</h2>
<table align="center" border="1">
    <tr>
        <td>成绩编号</td>
        <td>学号</td>
        <td>姓名</td>
        <td>项目名称</td>
        <td>比赛类型</td>
        <td>比赛分组</td>
        <td>项目成绩</td>
    </tr>
    <%
        for (int i=0; i<list.size(); i++){
            Score s = list.get(i);
    %>
    <tr>
        <td><%=s.getScoreid()%></td>
        <td><%=s.getMatch().getPlayer().getStudentid()%></td>
        <td><%=s.getMatch().getPlayer().getPlayername()%></td>
        <td><%=s.getMatch().getItem().getItemname()%></td>
        <td><%=s.getMatch().getMatchtype()==1? "初赛":"复赛"%></td>
        <td><%=s.getMatch().getGroup()%></td>
        <td><%=s.getScore()%></td>
    </tr>
    <%
        }
    %>
</table>
<h4 align="center"><a href=# onclick="javascript:history.back(-1);">返回</a> </h4>
</body>
</html>
