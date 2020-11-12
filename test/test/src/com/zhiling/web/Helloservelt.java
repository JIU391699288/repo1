package com.zhiling.web;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class Helloservelt implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("开始");
//        String values = servletConfig.getInitParameter("key");
//        System.out.println(values);
//        Enumeration<String> names = servletConfig.getInitParameterNames();
//        while (names.hasMoreElements()){
//            System.out.priintln(names.nextElement());
//        }
        String s = servletConfig.getServletName();
        System.out.println(s);


    }

    @Override
    public ServletConfig getServletConfig() {


        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("来到服务器");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("结束前执行");
    }
}
