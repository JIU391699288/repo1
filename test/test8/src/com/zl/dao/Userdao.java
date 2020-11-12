package com.zl.dao;

import com.zl.bean.User;
import com.zl.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Userdao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    public List<User>  select() throws Exception {

        List<User> list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    public int add(User user) throws Exception {
        int count = jdbcTemplate.update("insert into user values(null,?,?,?,?,?,?)", user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    return count;
    }

    public int delete(int id) throws  Exception{
        int count = jdbcTemplate.update("delete from user where id=?", id);
        return count ;
    }

    public User update1(int id) throws Exception {
        User user = jdbcTemplate.queryForObject("select * from user where id =?", new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    public int update2( User user) throws Exception {
        int count = jdbcTemplate.update("update user set name=?,sex=?,age=?,address=?,qq=?,email=? where id=?",
                user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        return count;
    }
    public int findCount() throws Exception{
        String sql = "select count(*) from user";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        return  count.intValue();
    }

    /**
     * 分页查询用户的列表
     * @param a
     * @param b
     * @return
     */
    public List<User> findLimit(int a, int b) throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from user limit ?,?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),a,b);
    }
}
