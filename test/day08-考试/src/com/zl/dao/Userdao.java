package com.zl.dao;

import com.zl.bean.User;

import java.util.List;

public interface Userdao {
    List<User>  select() throws Exception;

    int add(User u) throws Exception;

    int delete(int id) throws Exception;

    User update(int id) throws Exception;

    int updates(User user) throws Exception;

    int selectall() throws Exception;

    List<User> limit(int a, int b) throws Exception;
}
