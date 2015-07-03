<%@ page import="cn.net.hous.games.Player" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/18
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Player p = (Player)session.getAttribute("player");

    if (null != request.getParameter("hidden")){
        p.setPlayername(request.getParameter("playername"));
        p.setPlayersex(Integer.parseInt(request.getParameter("playersex")));
        p.setPlayerphone(request.getParameter("playerphone"));
        p.setPlayerother(request.getParameter("playerother"));

        if (Player.update(p)){
            out.print("<h2 align='center'>修改成功!</h2>");
        }
    }
%>
<html>
<head>
    <script language="JavaScript">
        function checkdate()
        {
            if(document.playername.value==null){
                alert("请输入正确姓名！");
                return false;
            }
            else{
                return true;
            }
        }
    </script>

    <title>修改信息</title>
</head>
<body>

<form name="form" action="playermodify.jsp" method="get" onSubmit="return checkdata()">
    <input type="hidden" name="hidden" value="reg">
    <table width="750" align="center" border="2">
        <tr>
            <td colspan="2" align="center">运动员注册</td>
        </tr>

        <tr>
            <td> 学号：</td>
            <td>
                <%=p.getStudentid()%>
            </td>
        </tr>

        <tr>
            <td>姓名</td>
            <td>
                <input type="input" name="playername" value="<%=p.getPlayername()%>">
            </td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                <input type=radio name="playersex" value="1" checked="checked">男
                <input type=radio name="playersex" value="0">女
            </td>
        </tr>

        <tr>
            <td>电话</td>
            <td>
                <input type="input" name="playerphone" value="<%=p.getPlayerphone()%>">
            </td>
        </tr>

        <tr>
            <td>备注</td>            <td>
            <textarea rows="12" cols="80" name="playerother" ><%=p.getPlayerother()%></textarea>
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
