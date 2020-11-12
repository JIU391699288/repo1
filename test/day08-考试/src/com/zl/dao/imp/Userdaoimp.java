package com.zl.dao.imp;

import com.zl.bean.PageBean;
import com.zl.bean.User;
import com.zl.dao.Userdao;
import com.zl.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Userdaoimp implements Userdao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> select() throws Exception{

        List<User> list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
//        System.out.println(list);
   return list;
    }

    @Override
    public int add(User u) throws Exception {
        int count = jdbcTemplate.update("insert into user values(null,?,?,?,?,?,?)",
                u.getName(), u.getSex(), u.getAge(), u.getAddress(), u.getQq(), u.getEmail());
        return count;

    }

    @Override
    public int delete(int id) throws Exception{
        int count = jdbcTemplate.update("delete from user where id =?", id);
        return count;
    }

    @Override
    public User update(int id) throws Exception{
        User user = jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    @Override
    public int updates(User user) throws Exception {
        int count = jdbcTemplate.update("update user set name=?,sex=?,age=?,address=?,qq=?,email=? where id =?",
                user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),user.getId());
        return count;
    }

    @Override
    public int selectall() throws Exception{
        Long list = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
//        System.out.println(list);
        return list.intValue();

    }

    @Override
    public List<User> limit(int a, int b) throws Exception {
        List<User> list = jdbcTemplate.query("select * from user limit ?,?", new BeanPropertyRowMapper<>(User.class), a, b);
//        System.out.println(list);
        return list;
    }
}
