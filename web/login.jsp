<%@ page import="cn.net.hous.games.Player" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/16
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getParameter("hidden") != null)
    {
        if (Player.login(Integer.parseInt(request.getParameter("studentid")), request.getParameter("playerpassword"))) {
            session.setAttribute("player", Player.getPlayerById(Integer.parseInt(request.getParameter("studentid"))));
            response.sendRedirect("user/playercenter.jsp");
        }else{
            out.print("<h3 align='center'>学号或密码错误请重试！</h3>");
        }
    }
%>
<html>
<head>
    <title>运动员登陆</title>
</head>
<body>
<a href="adminlogin.jsp">管理员登陆</a>
<br>
<br>
<br>
<h2 align="center">运动员登录</h2>
<form action="login.jsp" >
    <input type="hidden" name="hidden" value="hidden">
    <table align="center" border="1">
        <tr>
            <td>学号</td>
            <td><input type="text" name="studentid"></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" name="playerpassword"></td>
        </tr>

        <tr>
            <td><input type="submit" value="OK"></td>
        </tr>
    </table>
</form>

<br>
<br>
<br>
<h4 align="center" > <a href="register.jsp">新运动员注册</a> </h4>
</body>
</html>
