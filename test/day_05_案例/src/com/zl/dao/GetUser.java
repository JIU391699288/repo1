package com.zl.dao;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zl.bean.User;
import com.zl.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GetUser {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    public List<User> getall() throws Exception {
        List<User> list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    public int add(User user) throws Exception  {
        int count = jdbcTemplate.update("insert into user values(null,?,?,?,?,?,?)",
                user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return count;
    }

    public int delete(int id ) throws Exception  {
        int count = jdbcTemplate.update("delete from user where id=?", id);
        return count;
    }

    public User updsel(int id) throws Exception {
        User user = jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    public int update(User user) throws Exception{
        int count = jdbcTemplate.update("update user set name=?,sex=? ,age=?,address=?,qq=?,email=? where id=?",
                user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        return count;
    }
    public Long findcount() throws Exception{
        Long count = jdbcTemplate.queryForObject("select count(1) from user", long.class);
        return count;
    }

    public List<User> findlimit(int a, int b) throws Exception{
        List<User> list = jdbcTemplate.query("select * from user limit ?,?", new BeanPropertyRowMapper<>(User.class
        ),a, b);
        return list;
    }


}
