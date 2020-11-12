package com.zl.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchange.util.IntObjectMap;
import com.zl.utils.JDBCUtils;
import com.zl.utils.Word;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/demo02")
public class Servletdemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("key");//拿到前端输入的值

        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        try {
            List<Word> list = jdbcTemplate.query("select * from words where word like ?", //查询数据库里所有匹配的对象 返回一个集合
                    new BeanPropertyRowMapper<>(Word.class), keyword + "%");
            ObjectMapper objectMapper = new ObjectMapper();            //创建json库的ObjectMapper类
            String json = objectMapper.writeValueAsString(list);       //把java对象转换为匹配json结构
            response.getWriter().print(json);                          //把json响应给前端
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }
}
