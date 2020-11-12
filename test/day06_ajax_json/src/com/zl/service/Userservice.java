package com.zl.service;

import com.zl.dao.User;
import com.zl.utils.JDBCUtils;
import com.zl.utils.Users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Userservice {
    public static Users userservice( String username) throws Exception {
        User user = new User();
        Users users = user.getuser(username);
        return users;

    }
}
