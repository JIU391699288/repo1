package com.zl.service;
import com.zl.bean.PageBean;
import com.zl.bean.User;
import com.zl.dao.Getuser;
import java.util.List;
public class Userservice {
    Getuser getuser = new Getuser();
    public List<User> userservice() throws Exception {
        return  getuser.getuser() ;
    }

    public int add(User user) throws Exception {
        int count = getuser.add(user);
        return count;
    }

    public int delete(int id) throws Exception {
        return getuser.delete(id);
    }

    public User update1(int id) throws Exception {
        User user = getuser.update1(id);
        return user;
    }

    public int  update2(User user) throws Exception {
        return getuser.update2(user);
    }

    public PageBean findByPage(int curPage) {
        //调用Dao, 封装PageBean
        PageBean<User> pageBean = new PageBean<User>();

        //封装
        //一页显示的数量(自定义的)
        int curSize = 3;
        //用户的总数量(查)
        int count = getuser.findCount();
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
        List<User> list = getuser.findLimit(a,b);

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
