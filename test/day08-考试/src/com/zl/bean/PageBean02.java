package com.zl.bean;


import java.util.List;

/**
 * 封装分页的数据
 */
public class PageBean02 {

    //一页显示的用户的列表  List<User> list
    private List<User> list;
    //当前页码			  int curPage;
    private int curPage;
    //总页数			   int sumPage;
    private int sumPage;
    //用户的总数          int count;
    private int count;
    //一页显示的数量      int curSize;
    private int curSize;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getSumPage() {
        return sumPage;
    }

    public void setSumPage(int sumPage) {
        this.sumPage = sumPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurSize() {
        return curSize;
    }

    public void setCurSize(int curSize) {
        this.curSize = curSize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", curPage=" + curPage +
                ", sumPage=" + sumPage +
                ", count=" + count +
                ", curSize=" + curSize +
                '}';
    }
}
