package com.zl.service;

import com.zl.bean.User;
import com.zl.dao.Userss;

public class Services {


    public int add(User user) {
        Userss userss = new Userss();
        int count = userss.add(user);
        return count;
    }
}
