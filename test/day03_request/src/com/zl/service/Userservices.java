package com.zl.service;

import com.zl.bean.Users;
import com.zl.dao.Getuser;

public class Userservices {
    //业务层(service) 提供交互服务
    public  Users  Userservice(String username,String password) throws Exception{
        Getuser user = new Getuser();
        Users getuser = user.getuser(username, password);
        return getuser;


    }
}
