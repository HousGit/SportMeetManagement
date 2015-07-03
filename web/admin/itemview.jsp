<%@ page import="cn.net.hous.games.Item" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/18
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Item> list = Item.getItems();
%>
<html>
<head>
    <title></title>
</head>
<body>
<table align="center" border="1">
    <tr>
        <td>项目编号</td>
        <td>项目名称</td>
        <td>操作</td>
    </tr>
    <%
    for (int i=0; i<list.size(); i++){
    Item item = list.get(i);
    %>
    <tr>
        <td><%=item.getItemid()%></td>
        <td><%=item.getItemname()%></td>
        <td>
            <a href="itemdel.jsp?itemid=<%=item.getItemid()%>" onclick="return confirm('确定删除?')">删除</a>
            <a href="matchdetailbyitmid.jsp?id=<%=item.getItemid()%>">参赛详情</a>
            <a href="scorebyitmid.jsp?id=<%=item.getItemid()%>">比分详情</a>
        </td>
    </tr>
    <%
        }
    %>
    <tr>

    </tr>
</table>
</body>
</html>
