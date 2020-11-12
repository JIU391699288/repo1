package com.zl.web;

import com.zl.bean.PageBean;
import com.zl.service.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/demo06")
public class Servletdemo06 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //a 获得请求参数(curPage)
            int curPage = Integer.parseInt(request.getParameter("curPage"));

            //b.调用业务, 获得分页的数据 PageBean
            UserServices userService = new UserServices();
            PageBean pageBean =  userService.findByPage(curPage);
            //c,把pageBean存到request, 转发list_page.jsp页面
            request.setAttribute("pageBean",pageBean);
            System.out.println("pageBean="+pageBean);
            request.getRequestDispatcher("/list_page.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","服务器异常...");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
