package com.zl.service;

import com.zl.bean.PageBean;
import com.zl.bean.User;

import java.util.List;

public interface Userservice {
    List<User>  select() throws Exception;

    int add( User u) throws Exception;

    int delete(int id) throws Exception;

    User update(int id) throws Exception;

    int updates(User user) throws Exception;

    PageBean<User> findByPage(int curPage) throws Exception;
}
