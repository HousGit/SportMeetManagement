package cn.net.hous.games.Filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 帅 on 2015/7/3.
 */
@WebFilter(filterName = "AdminLoginFilter")
public class AdminLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getSession().getAttribute("admin") != null ){
            chain.doFilter(req, resp);
        }else{
            response.sendRedirect("/adminlogin.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
