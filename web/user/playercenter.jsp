<%@ page import="cn.net.hous.games.Player" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.net.hous.games.Item" %>
<%@ page import="cn.net.hous.games.Match" %>
<%@ page import="cn.net.hous.games.Score" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/17
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Player p = (Player)session.getAttribute("player");
    List<Match> matches = Match.getMatchesByStuid(p.getStudentid());
    List<Score> list = Score.getScoreByStuId(p.getStudentid());
%>
<html>
<head>
    <title>个人中心</title>
</head>
<body>

<h2 align="center" >个人信息</h2>
<table align="center" border="1">
    <tr>
        <td>编号</td>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>电话</td>
        <td>备注</td>
        <td>操作</td>
    </tr>

    <tr>
        <td><%=p.getPlayerid()%></td>
        <td><%=p.getStudentid()%></td>
        <td><%=p.getPlayername()%></td>
        <td><%=p.getPlayersex()==1 ? "男":"女"%></td>
        <td><%=p.getPlayerphone()%></td>
        <td><%=p.getPlayerother()%></td>
        <td><a href="playermodify.jsp" onclick="return confirm('确定修改？')">修改个人信息</a> </td>
    </tr>
</table>

<br>
<br>

<h2 align="center">参赛情况</h2>
<table align="center" border="1">
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>分组</td>
        <td>操作</td>
    </tr>
    <%
        for (int i=0; i<matches.size(); i++){
            Match m = matches.get(i);
    %>
    <tr>
        <td><%=m.getMatchid()%></td>
        <td><%=m.getItem().getItemname()%></td>
        <td><%=m.getGroup()%></td>
        <td><a href="matchdel.jsp?id=<%=m.getMatchid()%>" onclick="return confirm('确定删除?')">删除</a> </td>
    </tr>
    <%
        }
    %>
</table>
<br>
<center> <a href="join.jsp">比赛报名</a> </center>

<h2 align="center">成绩</h2>
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
</body>
</html>
