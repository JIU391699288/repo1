package com.zl.web;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo02")
public class Servletdemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("..success..");
        ValidateCode validateCode = new ValidateCode(100,50,4,10);
        String code = validateCode.getCode();
        System.out.println(code);
        request.getSession().setAttribute("code", code);//把验证码键值对存储到session中
        validateCode.write(response.getOutputStream());  //服务器通过输出流把验证码给响应到浏览器前端页面

    }
}
