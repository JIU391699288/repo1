package com.zl.service;

import com.zl.bean.PageBean;
import com.zl.bean.User;
import com.zl.dao.GetUser;

import java.util.List;

public class Userservice {
    GetUser getUser = new GetUser();
    public List<User> service() throws Exception {
        List<User> list =  getUser.getall();
        return list;
    }

    public int add(User user) throws Exception {
        int count = getUser.add(user);
        return count;
    }

    public int delete(int id ) throws Exception {
        int count = getUser.delete(id);
        return count;
    }

    public User updsel(int id) throws Exception {
        User user = getUser.updsel(id);
        return user;
    }

    public int update(User user) throws Exception {
        int count = getUser.update(user);
        return count;
    }

    public  PageBean<User> findByPage(int curPage) throws Exception {
        PageBean<User> pageBean = new PageBean<>();
        int curSize = 3;
       long count = getUser.findcount();
        long sumpage = 0;
       if (count%curSize==0){
            sumpage = count/curSize;
       }else {
            sumpage = count/curSize+1;
       }
       int b =curSize;
       int a = (curPage-1)*b;
      List<User> list= getUser.findlimit(a,b);
      pageBean.setCount((int) count);
      pageBean.setCurPage(curPage);
      pageBean.setCurSize(curSize);
      pageBean.setSumPage((int) sumpage);
      pageBean.setList(list);
      return pageBean;

    }
}
