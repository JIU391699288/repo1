package com.zl.web;

import com.zl.bean.User;
import com.zl.service.Services;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/demo02")
public class Servletdemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("success2");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            Services services = new Services();
            int count = services.add(user);
            if (count!=0){
                response.sendRedirect("/demo01");

//                request.getRequestDispatcher("/list.jsp").forward(request, response);
            }else{
                response.getWriter().print("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
