package com.cloudnote.filter;

import com.cloudnote.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class loginFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding( "utf-8" );

        System.out.println("111111111111");
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user);

        String url=req.getServletPath();
        //System.out.println(url);
        if(url.equals("/register.jsp")||url.equals("/login.jsp")||url.equals("/loginServlet")||url.equals("/registerServlet")||url.equals("/registerServletHibernate")||url.equals("/loginServletHibernate")){
            chain.doFilter(req,resp);
            return;
        }else {
            if(user==null){
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
//                chain.doFilter(req,resp);
                return;
            }
            else{
                chain.doFilter(req,resp);
                return;
            }
        }

}

    public void init(FilterConfig config) throws ServletException {

    }

}
