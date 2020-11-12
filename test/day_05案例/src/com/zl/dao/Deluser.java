package com.zl.dao;

import com.zl.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Deluser {
    public int del(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "delete from user where id = ?";
        int del = jdbcTemplate.update(sql, id);
        return del;
    }
}
