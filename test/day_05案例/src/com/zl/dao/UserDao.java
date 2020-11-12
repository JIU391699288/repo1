package com.zl.dao;

import com.zl.bean.User;
import com.zl.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {
    /**
     * 统计用户的总数量
     * @return
     */
    public int findCount() throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
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
