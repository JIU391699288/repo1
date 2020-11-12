package com.zl.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/Demo01")
public class Servletdemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("..success.");
        boolean flag = false;
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie!=null&&cookie.getName().equals("last")){
                    System.out.println("上一次访问时间:"+new Date(Long.parseLong(cookie.getValue())));
                    flag=true;
                    cookie.setValue(""+System.currentTimeMillis());
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        if (flag==false){
            System.out.println("第一次访问");
            Cookie cookie =new Cookie("last", ""+System.currentTimeMillis());
            resp.addCookie(cookie);

        }


    }
}
