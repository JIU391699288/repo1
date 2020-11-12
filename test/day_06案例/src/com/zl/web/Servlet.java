package com.zl.web;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zl.bean.PageBean;
import com.zl.bean.User;
import com.zl.service.Userservice;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/user")
public class Servlet extends HttpServlet {
    Userservice Userservice =  new Userservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (request.getParameter("method").equals("list")){
            select(request, response);
        }
        if (request.getParameter("method").equals("add")){
            add(request, response);
        }
        if (request.getParameter("method").equals("delete")){
            delete(request, response);
        }
        if (request.getParameter("method").equals("update1")){
            update1(request, response);
        }
        if (request.getParameter("method").equals("update2")){
            update2(request, response);
        }
        if (request.getParameter("method").equals("findByPage")){
            findByPage(request, response);
        }

    }
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = Userservice.userservice();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       User  user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            int count = Userservice.add(user);
            System.out.println(user);
            if (count!=0){
                select(request, response);
            }else {
                response.getWriter().print("添加失败");
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
          int count = Userservice.delete(id);
            if (count!=0){
                select(request, response);
            }else {
                response.getWriter().print("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            User  user = Userservice.update1(id);
            request.setAttribute("user", user);
            user.setId(id);
            request.getRequestDispatcher("/update.jsp").forward(request,response );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            int count = Userservice.update2(user);
            System.out.println(count);
            if (count!=0){
                select(request, response);
            }else {
                response.getWriter().print("更新失败");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("更新失败2");
        }


    }
    public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //a 获得请求参数(curPage)
            int curPage = Integer.parseInt(request.getParameter("curPage"));
            //b.调用业务, 获得分页的数据 PageBean

            PageBean pageBean = Userservice.findByPage(curPage);

            //c,把pageBean存到request, 转发list_page.jsp页面
            request.setAttribute("pageBean", pageBean);
            System.out.println("pageBean=" + pageBean);
            request.getRequestDispatcher("/list_page.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "服务器异常...");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doPost(request, response);
    }
}
