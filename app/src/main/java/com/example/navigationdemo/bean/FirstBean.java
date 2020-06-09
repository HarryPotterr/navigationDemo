package com.example.navigationdemo.bean;

import java.io.Serializable;

public class FirstBean implements Serializable {
    private String msg;
    private int id;

    public FirstBean(String msg, int id) {
        this.msg = msg;
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
