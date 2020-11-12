package com.zl.dao;

import com.zl.utils.JDBCUtils;
import com.zl.utils.Users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class User {
    public static Users getuser( String username) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        Users users = jdbcTemplate.queryForObject("SELECT * FROM users where username=? ",
                new BeanPropertyRowMapper<>(Users.class), username);
        return users;
    }
}
