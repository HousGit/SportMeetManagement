<%@ page import="cn.net.hous.games.Item" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/18
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (null != request.getParameter("hidden")){
        Item item = new Item();
        item.setItemname(request.getParameter("itemname"));
        item.save();
        out.print("<h2 align='center' >添加成功!</h2>");
    }
%>
<html>
<head>
    <title>添加比赛</title>
</head>
<body>

<form name="form" action="addgames.jsp" method="get" onSubmit="return confirm('确定提交?')">
    <input type="hidden" name="hidden" value="reg">
    <table width="750" align="center" border="2">
        <tr>
            <td colspan="2" align="center">添加比赛</td>
        </tr>
        <tr>
            <td> 比赛名称：</td>
            <td>
                <input type=text name="itemname" size="30" maxlength="10">
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
