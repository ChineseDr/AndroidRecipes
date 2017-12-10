package com.example.eventbusl;

/**
 * 消息封装发送的数据
 * Created by ray on 2017/12/10.
 */

public class MyMessage {
    private String msg;

    public MyMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
