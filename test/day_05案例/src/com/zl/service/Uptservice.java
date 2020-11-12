package com.zl.service;

import com.zl.bean.User;
import com.zl.dao.Uptuse;

public class Uptservice {

    public int uptservices(User user,int id) {
        Uptuse uptuse = new Uptuse();
        int update = uptuse.uptuser(user, id);
        return update;

    }
}
