package com.zl.web;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo03")
public class Servletdemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
        String code = request.getParameter("code");//拿到用户输入的验证码值
        Object code1 = request.getSession().getAttribute("code");//拿到session里存储的正确验证码值
        if (code.equals(code1)){
            response.getWriter().print("输入正确");

        }else {
            response.getWriter().print("验证码输入错误");
        }
    }
}
