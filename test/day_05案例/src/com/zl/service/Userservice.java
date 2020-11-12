package com.zl.service;

import com.zl.bean.User;
import com.zl.dao.Users;

import java.util.List;

public class Userservice {

    public List<User> Findall() throws Exception {
        Users users = new Users();
        List<User> user =  users.Findall();
       return user;
    }
}
