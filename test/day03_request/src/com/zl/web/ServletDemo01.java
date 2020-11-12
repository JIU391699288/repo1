package com.zl.web;

import com.zl.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/Demo1")
public class ServletDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do...get...");
//        String username = request.getParameter("username");//we
//        System.out.println(username);
//        String password = request.getParameter("password");//12
//        System.out.println(password);
//        String hobby = request.getParameter("hobby");
//        System.out.println(hobby);
// String[] username = request.getParameterValues("username");//we
//        for (String u : username) {
//            System.out.println(u);
//        }
//        String[] password = request.getParameterValues("password");//12
//        for (String p : password) {
//            System.out.println(p);
//        }
//        String[] hobby = request.getParameterValues("hobby");
//        for (String s : hobby) {
//            System.out.println(s);
//        }
        Map<String, String[]> map = request.getParameterMap();
        User u = new User();
        try {
            BeanUtils.populate(u, map);
            System.out.println(u);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
