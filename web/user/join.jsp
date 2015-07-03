<%@ page import="cn.net.hous.games.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.net.hous.games.Match" %>
<%@ page import="cn.net.hous.games.Player" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/19
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Item> list = Item.getItems();
    if (null != request.getParameter("hidden")){
        Player player = (Player)session.getAttribute("player");
        String[] match = request.getParameterValues("match");
        for (int i=0; i<match.length; i++){
            Match.save(player.getStudentid(), Integer.parseInt(match[i]));
        }
        out.print("<h2 align='center'>报名成功!</h2>");
    }
%>
<html>
<head>
    <title></title>
</head>
<body>
<form action="join.jsp" onsubmit="return confirm('sure?')" method="get">
    <input type="hidden" name="hidden" value="hidden">
    <table align="center" border="1">
        <tr>
            <td>选择项目</td>
        </tr>
        <%
            for (int i=0; i<list.size(); i++){
                Item item = list.get(i);
        %>
        <tr>
            <td><%=item.getItemname()%><input type="checkbox" name="match" value="<%=item.getItemid()%>" ></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td><input type="submit" value="OK">&nbsp;<a href="playercenter.jsp">返回</a></td>
        </tr>

    </table>
</form>
</body>
</html>
