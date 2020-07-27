package com.iflytek.edu.config;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yq
 * @create 2020-07-14-11:12
 **/
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        System.out.println("this is MyFilter2,url :"+request.getRequestURI());
        filterChain.doFilter(srequest, sresponse);
    }

    @Override
    public void destroy() {

    }
}
