<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/7/3
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (null != request.getParameter("hidden")){
        if (request.getParameter("adminid").equals("admin") && request.getParameter("adminpassword").equals("admin")){
            session.setAttribute("admin","admin");
            response.sendRedirect("admin/AdminIndex.html");
        }else {
            out.print("<h2 align='center' >密码错误</h2>");
        }
    }
%>
<html>
<head>
    <title></title>
</head>
<body>
<h2 align="center">管理员登录</h2>
    <form action="adminlogin.jsp" >
        <input type="hidden" name="hidden" value="hidden">
        <table align="center" border="1">
            <tr>
                <td>账号</td>
                <td><input type="text" name="adminid"></td>
            </tr>

            <tr>
                <td>密码</td>
                <td><input type="password" name="adminpassword"></td>
            </tr>

            <tr>
                <td><input type="submit" value="OK"></td>
            </tr>
        </table>
    </form>
</body>
</html>
