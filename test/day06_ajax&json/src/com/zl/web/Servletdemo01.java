package com.zl.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zl.utils.JDBCUtils;
import com.zl.utils.Users;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/demo01")
public class Servletdemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
            Users users = jdbcTemplate.queryForObject("select * from users where username=?", new BeanPropertyRowMapper<>(Users.class),
                    username);
//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = objectMapper.writeValueAsString(users);
//            request.getRequestDispatcher("/01_index.html").forward(request, response);
            if (users.getUsername()!=null){
                response.getWriter().print("flase");

            }
        } catch (Exception e) {
//            e.printStackTrace();
            response.getWriter().print("true");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
