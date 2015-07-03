package cn.net.hous.games;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 帅 on 2015/6/28.
 */
@WebServlet(name = "matchgroup")
public class matchgroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Match.groupById(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("matchtype")));
        PrintWriter out = response.getWriter();
        response.sendRedirect("/admin/matchdetailbyitmid.jsp?id="+request.getParameter("id"));
    }
}
