package com.zl.bean;


import java.util.List;

public class PageBean<T> {
/*	商品的列表数据 List<Product> list
	当前页         int curPage
	总页数		   int sumPage
	总数量		   int count
	一页显示数量   int curSize:
	*/

	private List<T> list;
	private int curPage;
	private int sumPage;
	private int count;
	private int curSize;

	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
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

}