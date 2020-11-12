package com.zl.dao;

import com.zl.bean.User;
import com.zl.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Uptusers {
    public  User uptuserss(int id) throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from user where id =?";
        User list = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return list;
    }
}
