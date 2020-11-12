package com.zl.web;

import com.zl.bean.User;
import com.zl.service.Uptser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/demo05")
public class Servletdemo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("success");
        int id = Integer.parseInt(request.getParameter("id"));
//        System.out.println(id);
        Uptser uptser = new Uptser();
        try {
            User list = uptser.uptsers(id);
            request.setAttribute("list", list);
//            System.out.println(list);
            request.getRequestDispatcher("/update.jsp").forward(request, response);


        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
