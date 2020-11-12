package com.zl.web;

import cn.dsna.util.images.ValidateCode;
import com.zl.units.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo03")
public class ServletDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do..get..");
        ValidateCode validateCode = new ValidateCode(100,50, 6, 20);
        String code = validateCode.getCode();
        System.out.println(code);//打印验证码到后台
        validateCode.write(response.getOutputStream());
        try {
            String s = Md5Util.encodeByMd5(code);//对验证码进行加密并打印出来
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

