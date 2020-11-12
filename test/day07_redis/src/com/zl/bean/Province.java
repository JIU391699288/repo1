package com.zl.bean;

import java.io.Serializable;

public class Province implements Serializable {
    private Integer pid;
    private  String pname;

    public Province() {
    }

    public Province(Integer pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
