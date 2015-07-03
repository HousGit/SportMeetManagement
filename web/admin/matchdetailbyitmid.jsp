<%@ page import="java.util.List" %>
<%@ page import="cn.net.hous.games.Match" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/20
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Match> matches = Match.getMatchesByItmid(Integer.parseInt(request.getParameter("id")));
%>
<html>
<head>
    <title></title>
</head>
<body>
<h2 align="center">参赛情况</h2>
<center>
    <a  align="center" href="/matchgroup?id=<%=Integer.parseInt(request.getParameter("id"))%>&matchtype=1" onclick="return confirm('sure?')">初赛分组</a>&nbsp;
    <a  align="center" href="/matchgroup?id=<%=Integer.parseInt(request.getParameter("id"))%>&matchtype=2" onclick="return confirm('sure?')">复赛分组</a>&nbsp;
    <a href="generatefinal.jsp?id=<%=Integer.parseInt(request.getParameter("id"))%>" onclick="return confirm('sure?')">生成复赛名单</a>
    <a href="deletefinalbyid.jsp?id=<%=Integer.parseInt(request.getParameter("id"))%>" onclick="return confirm('该操作会删除所有复赛记录且不可恢复，确定？?')">清除复赛名单</a>

</center>
<table align="center" border="1">
    <tr>
        <td>比赛编号</td>
        <td>学号</td>
        <td>姓名</td>
        <td>比赛名称</td>
        <td>比赛类型</td>
        <td>分组</td>
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
        <td><%=m.getMatchtype()==1? "初赛" : "复赛"%></td>
        <td><%=m.getGroup()%></td>
    </tr>
    <%
        }
    %>
</table>
<h4 align="center"><a href="./itemview.jsp">返回</a> </h4>
</body>
</html>
