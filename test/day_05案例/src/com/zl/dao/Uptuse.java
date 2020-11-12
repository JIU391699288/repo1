package com.zl.dao;

import com.zl.bean.User;
import com.zl.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Uptuse {
    public int uptuser(User user,int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql= "update user set name=?, sex=? , age=? , address=? , qq=? , email=? where id = ?";
        int update = jdbcTemplate.update(sql, user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),id);
        return update;
    }
}
