package com.zl.service.imp;

import com.zl.bean.PageBean;
import com.zl.bean.User;
import com.zl.dao.Userdao;
import com.zl.dao.imp.Userdaoimp;
import com.zl.service.Userservice;

import java.util.List;

public class Userserviceimp implements Userservice {
    Userdao userdao =new Userdaoimp();
    @Override
    public List<User> select() throws Exception {

        List<User> list =  userdao.select();
        return list;
    }

    @Override
    public int add(User u) throws Exception{
      int count =   userdao.add(u);
      return count;

    }

    @Override
    public int delete(int id) throws Exception {
      int count = userdao.delete(id);
      return count;

    }

    @Override
    public User update(int id) throws Exception{

     User user =   userdao.update(id);
     return user;
    }

    @Override
    public int updates(User user) throws Exception {

       int count = userdao.updates(user);
       return count;
    }

    @Override
    public PageBean<User> findByPage(int curPage) throws Exception{
       int count = userdao.selectall();
       PageBean<User> PageBean = new PageBean();
       int curSize = 3;
        int sumPage;
       if (count%curSize==0){
           sumPage=count/curSize;
       }else {
           sumPage=count/curSize+1;
       }
       int b = curSize;
       int a = (curPage-1)*b;
     List<User> list =  userdao.limit(a,b);
     PageBean.setList(list);
     PageBean.setSumPage(sumPage);
     PageBean.setCurSize(curSize);
     PageBean.setCurPage(curPage);
     PageBean.setCount(count);
        return PageBean;

    }
}
