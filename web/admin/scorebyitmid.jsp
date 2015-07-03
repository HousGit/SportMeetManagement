<%@ page import="java.util.List" %>
<%@ page import="cn.net.hous.games.Score" %>
<%--
  Created by IntelliJ IDEA.
  User: 帅
  Date: 2015/6/27
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Score> list = Score.getScoreByItmId(Integer.parseInt(request.getParameter("id")));
    if (null != request.getParameter("hidden")){
        String[] scores = request.getParameterValues("submitscores");
        for (int i=0; i<scores.length; i++){
            Score.update(list.get(i).getScoreid(), scores[i]);
        }
        list = Score.getScoreByItmId(Integer.parseInt(request.getParameter("id")));
        out.print("<h3 align='center' >修改成功</h3>");
    }
%>
<html>
<head>
    <title></title>
</head>
<body>
<h2 align="center">成绩列表</h2>
<form action="scorebyitmid.jsp" onsubmit="return confirm('sure?')" method="get">
    <input type="hidden" name="hidden" value="hidden">
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    <table align="center" border="1">
        <tr>
            <td>成绩编号</td>
            <td>学号</td>
            <td>姓名</td>
            <td>项目名称</td>
            <td>分组</td>
            <td>比赛类型</td>
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
            <td><%=s.getMatch().getGroup()%></td>
            <td><%=(s.getMatch().getMatchtype()==1? "初赛" : "复赛")%></td>
            <td><input type="text" name="submitscores" value="<%=s.getScore()%>"></td>
        </tr>
        <%
            }
        %>
    </table>
   <center><input type="submit" value="修改"></center>
    <h4 align="center"><a href=# onclick="javascript:history.back(-1)">返回</a> </h4>
</form>
</body>
</html>
