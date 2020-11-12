package com.zl.web;

import com.sun.org.apache.bcel.internal.generic.IFNONNULL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/Demo01")
public class Servletdemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login..success");
        Cookie[] cookies = req.getCookies();//假设有cookie访问记录
        boolean flag = false; //定义一个全局变量
        if (cookies!=null){
            for (Cookie cookie : cookies) {  //拿到cookie 得到上次访问的时间的值
                if (cookie!=null&&"last".equals(cookie.getName())){
                    System.out.println("返回上次登录时间"+new Date(Long.parseLong(cookie.getValue())).toLocaleString());
                    flag=true;  //有访问的话值改为true  以后访问都不走下面的flase第一次访问
                    cookie.setValue(""+System.currentTimeMillis()); //返回后需要更新cookie里的数据 既上次访问时间为现在的系统毫秒值
                    resp.addCookie(cookie); //更新完后添加并响应给浏览器(因为会话技术只能存活一次会话时间,如果浏览器关闭 则再次访问时相当于第一次访问)
                    break;
                }
            }

        }
        if (flag==false){ //如果是第一次访问来到这里
            System.out.println("欢迎访问网站");
            Cookie cookie = new Cookie("last", ""+System.currentTimeMillis()); //记录一下第一次访问的系统毫秒值
//            cookie.setMaxAge(60*60);//cookie存活时间设置 以秒为单位  设置为0 表明cookie不存活 消失
            resp.addCookie(cookie);//把键值对存入cookie中并响应给浏览器,以后的访问都从这里拿数据


        }
    }
}
