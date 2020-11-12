package com.zl.dao;

import com.zl.units.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class User {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    }


}
