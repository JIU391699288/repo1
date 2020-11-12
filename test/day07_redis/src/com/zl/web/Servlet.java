package com.zl.web;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zl.bean.Province;
import com.zl.utils.JDBCUtils;
import com.zl.utils.JedisUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/demo01")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("utf-8");
     response.setContentType("text/html;charset=utf-8");
        Jedis jedis = JedisUtils.getJedis();
        String p = jedis.get("p");
        if (p!=null){
            System.out.println("数据来源于jedis");
            response.getWriter().print(p);
        }
        else {
            System.out.println("数据来源于sql硬盘");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
            List<Province> list = jdbcTemplate.query("select * from province", new BeanPropertyRowMapper<>(Province.class));
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(list);
            System.out.println(list);
            response.getWriter().print(json);
            jedis.set("p", json);
            jedis.close();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
