package com.zl.web;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zl.bean.User;
import com.zl.service.Uptservice;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/demo04")
public class Servletdemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            int id = Integer.parseInt(request.getParameter("id"));
            Uptservice uptservice = new Uptservice();
            int update = uptservice.uptservices(user, id);
            if (update!=0){
//                response.getWriter().print("修改成功");
                response.sendRedirect("/demo01");
            } else{
                response.getWriter().print("修改失败");
            }
//            request.getRequestDispatcher("/list.jsp").forward(request, response);
//            System.out.println(user);
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("修改失败2");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
