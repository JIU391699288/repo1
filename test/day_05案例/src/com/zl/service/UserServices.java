package com.zl.service;


import com.zl.bean.PageBean;
import com.zl.bean.User;
import com.zl.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class UserServices {
    public PageBean findByPage(int curPage) throws Exception {
        //调用Dao, 封装PageBean
        UserDao userDao = new UserDao();
        PageBean<User> pageBean = new PageBean<User>();

        //封装
        //一页显示的数量(自定义的)
        int curSize = 3;
        //用户的总数量(查)
        int count = userDao.findCount();
        //总页码(算的)
        int sumPage = 0;
        if(count % curSize == 0){
            sumPage = count/curSize;
        }else{
            sumPage = count/curSize+1;
        }

        //用户的列表List(查)  limit a ,b
        int b = curSize;
        int a = (curPage-1)*b;
        List<User> list = userDao.findLimit(a,b);

        //a. 封装当前的页码
        pageBean.setCurPage(curPage);
        //b 封装一页显示的数量(自定义的)
        pageBean.setCurSize(curSize);
        //c. 封装用户的总数量(查)
        pageBean.setCount(count);
        //d. 封装总页码(算的)
        pageBean.setSumPage(sumPage);
        //e. 封装用户的列表List(查)
        pageBean.setList(list);
        return  pageBean;
    }
}
