package com.zl.web;

import com.zl.service.Delservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo03")
public class Servletdemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("success3");
            int id = Integer.parseInt(request.getParameter("id"));
            Delservice delservice = new Delservice();
        int del = delservice.Del(id);
        if (del!=0){
            response.sendRedirect("/demo01");
        }else {
            System.out.println("del fail");
        }
    }

}
