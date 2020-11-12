package com.zl.web;

import com.zl.bean.User;
import com.zl.bean.Users;
import com.zl.service.Userservices;
import com.zl.units.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/Demo2")
public class ServletDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do...get...");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
//            JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
//            Users users = jdbcTemplate.queryForObject("select * from users where username=? and password=? ",
//                    new BeanPropertyRowMapper<>(Users.class), username, password);
            //web selvlet层 对数据进行处理
            Userservices userservices = new Userservices();
            Users users = userservices.Userservice(username, password);
            if (users!=null){
//                response.getWriter().print("login..success");
                response.sendRedirect("http://www.baidu.com");//登录成功跳转到百度

            }else {
                response.getWriter().print("login..fail");
            }
        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().print("login..fail2");
            request.getRequestDispatcher("c.html").forward(request, response);//失败跳转到内部二维码验证页面


        }


    }
}
