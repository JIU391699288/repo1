package com.zl.web;

import com.zl.bean.PageBean;
import com.zl.bean.User;
import com.zl.service.Userservice;
import com.zl.service.imp.Userserviceimp;
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
    Userservice userservice = new Userserviceimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (request.getParameter("method").equals("select")){
            select(request,response);
        }
        if (request.getParameter("method").equals("add")){
            add(request,response);
        }
        if (request.getParameter("method").equals("delete")){
            delete(request,response);
        }
        if (request.getParameter("method").equals("update")){
            update(request,response);
        }
        if (request.getParameter("method").equals("updates")){
            updates(request,response);
        }
        if (request.getParameter("method").equals("findByPage")){
            findByPage(request,response);
        }
    }
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int curPage = Integer.parseInt(request.getParameter("curPage"));
            PageBean<User> pageBean = userservice.findByPage(curPage);
//            System.out.println(pageBean);
            request.setAttribute("pageBean", pageBean);
            request.getRequestDispatcher("/list_page.jsp").forward(request, response);
        } catch (Exception e) {
//            e.printStackTrace();
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("输入页码有误");

        }
    }
    protected void updates(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
          int count =  userservice.updates(user);
            if (count!=0){
                select(request, response);
            }
            else {
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("修改失败");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("修改失败2");
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            User user =  userservice.update(id);
            user.setId(id);
            request.setAttribute("user",user );
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            int count = userservice.delete(id);
            if (count!=0){
                select(request, response);
            }
            else {
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("删除失败");
            }

        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u =new User();
        try {
             BeanUtils.populate(u, request.getParameterMap());
           int count =  userservice.add(u);
           if (count!=0){
               select(request, response);
           }
           else {
               request.setCharacterEncoding("utf-8");
               response.setContentType("text/html;charset=utf-8");
               response.getWriter().print("添加失败");
           }
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("添加失败2");
        }
    }
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            List<User> list = userservice.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/list.jsp").forward(request,response );
        } catch (Exception e) {
//            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
