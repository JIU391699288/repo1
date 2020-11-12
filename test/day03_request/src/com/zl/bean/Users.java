package com.zl.bean;

import java.io.Serializable;

public class Users implements Serializable {
    private Integer id;
    private String usename;
    private  String passwod;

    public Users() {
    }

    public Users(Integer id, String usename, String passwod) {
        this.id = id;
        this.usename = usename;
        this.passwod = passwod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPasswod() {
        return passwod;
    }

    public void setPasswod(String passwod) {
        this.passwod = passwod;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", usename='" + usename + '\'' +
                ", passwod='" + passwod + '\'' +
                '}';
    }
}
