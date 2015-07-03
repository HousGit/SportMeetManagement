<%@ page import="java.util.List" %>
<%@ page import="cn.net.hous.games.Player" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/17
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Player> list = Player.getPlayers();
%>
<html>
<head>
    <title></title>
</head>
<body>
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

    <%

        for (int i=0; i<list.size(); i++){
            Player p = list.get(i);
     %>
        <tr>
            <td><%=p.getPlayerid()%></td>
            <td><%=p.getStudentid()%></td>
            <td><%=p.getPlayername()%></td>
            <td><%=p.getPlayersex()==1 ? "男":"女"%></td>
            <td><%=p.getPlayerphone()%></td>
            <td><%=p.getPlayerother()%></td>
            <td>
                <a href="playerdel.jsp?studentid=<%=p.getStudentid()%>" onclick="return confirm('确定删除？')">删除</a>
                <a href="matchdetailbystuid.jsp?id=<%=p.getStudentid()%>">参赛情况</a>
                <a href="scorebystuid.jsp?id=<%=p.getStudentid()%>">比赛成绩</a>
            </td>
        </tr>
    <%
        }
    %>

</table>
</body>
</html>
