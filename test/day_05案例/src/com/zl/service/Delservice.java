package com.zl.service;

import com.zl.dao.Deluser;

public class Delservice {
    public int Del(int id) {
        Deluser deluser = new Deluser();
        int del = deluser.del(id);
        return del;
    }
}
