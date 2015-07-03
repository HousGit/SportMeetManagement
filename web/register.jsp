<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/12
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getParameter("hidden") != null){
%>

<jsp:useBean id="player" class="cn.net.hous.games.Player"/>
<jsp:setProperty name="player" property="*"/>
    <%
        if (player.check())
        {
            player.sava();
            out.print("<center>注册成功！<a href=\"login.jsp\" >点击登陆</a></center>");
        }else {
            out.print(player.getErr("pstuidErr")+player.getErr("ppswErr")+player.getErr("pnameErr"));
        }
    %>

<%
    }
%>
<html>
<head>
    <title>运动员注册</title>
    <script language="JavaScript">
        function checkdate()
        {
            var usm = document.form.studentid.value;
            if(!usm.match(/\w{11}/)){
                alert("学号格式不正确！");
                return false;
            }
            if(document.form.playerpassword.value != document.form.repassword.value){
                alert("两次密码输入不一致！");
                return false;
            }
            if(document.form.playerpassword.value.match(/\w{6,12}/)){
                alert("请输入6到12位密码！");
                return false;
            }
            if(document.form.playername.value==null){
            alert("请输入正确姓名！");
            return false;
            }
            else{
                return true;
            }
        }
    </script>
</head>
<body>

<form name="form" action="register.jsp" method="get" onSubmit="return checkdata()">
    <input type="hidden" name="hidden" value="reg">
    <table width="750" align="center" border="2">
        <tr>
            <td colspan="2" align="center">运动员注册</td>
        </tr>
        <tr>
            <td> 学号：</td>
            <td>
                <input type=text name="studentid" size="30" maxlength="10">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type=password name="playerpassword" size="15" maxlength="12">
            </td>
        </tr>
        <tr>
            <td>密码确认</td>
            <td>
                <input type=password name="repassword" size="15" maxlength="12">
            </td>
        </tr>

        <tr>
            <td>姓名</td>
            <td>
                <input type="input" name="playername" >
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
                <input type="input" name="playerphone" >
            </td>
        </tr>

        <tr>
            <td>备注</td>            <td>
                <textarea rows="12" cols="80" name="playerother"></textarea>
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
