package com.arun;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class checkFilter implements Filter {


    public void init(FilterConfig filterConfig)
            throws ServletException
    {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Inside Filter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;


        filterChain.doFilter(servletRequest,servletResponse);
    }


    public void destroy() {}

}
