package com.zl.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet("*.do")
@WebServlet("/aa/*")
public class Helloservelt extends HttpServlet   {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    //    @Override
//    public void init(ServletConfig servletConfig) throws ServletException {
//
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return null;
//    }
//
//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("浏览器有访问服务器了");
//        HttpServletResponse hsr = (HttpServletResponse) servletResponse;
//        hsr.getWriter().print("response");
//        hsr.setHeader("refresh", "5;url=http://www.baidu.com");
//
//
//
//    }
//
//    @Override
//    public String getServletInfo() {
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
}
