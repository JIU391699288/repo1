package com.zl.web;

import com.sun.org.apache.bcel.internal.generic.Select;
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
import java.util.Map;

@WebServlet("/user")
public class ServletUsers extends HttpServlet {
    Userservice userservice = new Userservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        List<User> list = null;
        try {
            list = userservice.service();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (Exception e) {
//            e.printStackTrace();
        }

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            int count = userservice.add(user);
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
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int count = userservice.delete(id);
            if (count!=0){
                select(request, response);
            }else {
                response.getWriter().print("删除失败");
            }
        }catch (Exception e) {
//            e.printStackTrace();
        }
    }
    protected void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            User user = userservice.updsel(id);
            user.setId(id);
            request.setAttribute("user", user);
           request.getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
    protected void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            int count = userservice.update(user);
            if (count!=0){
                select(request, response);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("修改失败");
        }

    }
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int curPage = Integer.parseInt(request.getParameter("curPage"));
            BeanUtils.populate(curPage, request.getParameterMap());
            PageBean<User> pageBean = userservice.findByPage(curPage);
            System.out.println(curPage);
            request.setAttribute("pageBean", pageBean);
            request.getRequestDispatcher("/list_page.jsp").forward(request, response);
        } catch (Exception e) {
//            e.printStackTrace();
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("服务器异常");
        }
    }
}
