package com.zl.web;

import com.zl.service.Userservice;
import com.zl.utils.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo01")
public class Servletdemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        try {
            Userservice userservice = new Userservice();
            Users users = userservice.userservice(username);
            String username1 = users.getUsername();
            if (username1!=null){
                response.getWriter().print("false");
            }

        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("true");
        }

    }
}
