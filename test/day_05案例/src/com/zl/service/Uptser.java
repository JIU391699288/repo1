package com.zl.service;

import com.zl.bean.User;
import com.zl.dao.Uptusers;

import java.util.List;

public class Uptser {
    public User uptsers(int id) throws Exception {
        Uptusers uptusers = new Uptusers();
        User uptuser = uptusers.uptuserss(id);
        return uptuser;

    }
}
