package com.arun;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class secondFilter implements Filter {


    public void init(FilterConfig filterConfig)
            throws ServletException
    {
        System.out.println("Filter Init Method");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Inside Second Filter");
        filterChain.doFilter(servletRequest,servletResponse);
    }


    public void destroy() {

        System.out.println("Filter Destroy Method");
    }

}
