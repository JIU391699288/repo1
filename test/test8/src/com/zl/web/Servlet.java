package com.zl.web;

import com.sun.org.apache.bcel.internal.generic.NEW;
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
public class Servlet extends HttpServlet {
    Userservice userservice = new Userservice();
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
        if (request.getParameter("method").equals("update1")){
            update1(request,response);
        }
        if (request.getParameter("method").equals("update2")){
            update2(request,response);
        }
        if (request.getParameter("method").equals("findByPage")){
            findByPage(request,response);
        }
    }
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> list = userservice.select();
//            System.out.println(list);
           request.setAttribute("users", list);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("fail");
        }
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            User user = new User();
            BeanUtils.populate(user, request.getParameterMap());
            int count = userservice.add(user);
            if (count!=0){
                select(request, response);
            }
            else {
                response.getWriter().print("fail1");
            }

        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("fail2");
        }
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int count = 0;
        try {
            count = userservice.delete(id);
            if (count!=0){
                select(request, response);
            }else {
                response.getWriter().print("fail3");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("fail4");
        }

    }
    protected void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = null;
        try {
            user = userservice.update1(id);
            user.setId(id);
            request.setAttribute("userss",user );
            System.out.println(user);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
            int count =  userservice.update2(user);
            if (count!=0){
                select(request, response);
            }else {
                response.getWriter().print("fail4");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("fail5");
        }


    }
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //a 获得请求参数(curPage)
            int curPage = Integer.parseInt(request.getParameter("curPage"));

            //b.调用业务, 获得分页的数据 PageBean
            PageBean pageBean = userservice.findByPage(curPage);
//            PageBean pageBean =  Userservice.findByPage(curPage);
            //c,把pageBean存到request, 转发list_page.jsp页面
            request.setAttribute("pageBean",pageBean);
            System.out.println("pageBean="+pageBean);
            request.getRequestDispatcher("/list_page.jsp").forward(request,response);
        } catch (Exception e) {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("错误");
//            e.printStackTrace();
//            request.setAttribute("msg","服务器异常...");
//            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
