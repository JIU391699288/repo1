package com.zl.dao;

import com.zl.bean.Users;
import com.zl.units.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//持久层(dao) jdbc和数据库交互
public class Getuser {
    public  Users getuser( String username,String password) throws Exception{
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
        Users users = jdbcTemplate.queryForObject("select * from users where username=? and password=? ",
                new BeanPropertyRowMapper<>(Users.class), username, password);
        return users;
    }

}
