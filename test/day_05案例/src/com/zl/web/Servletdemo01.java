package com.zl.web;

import com.zl.bean.User;
import com.zl.service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/demo01")
public class Servletdemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("..success..");
        Userservice userservice = new Userservice();
        try {
            List<User> list= userservice.Findall();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/list.jsp").forward(request, response);

        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
