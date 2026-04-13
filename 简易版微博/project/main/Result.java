package com.weibo.entity;

public class Result {
    private boolean success;
    private String msg;
    private Object data;

    public static Result success(String msg) {
        Result r = new Result();
        r.success = true;
        r.msg = msg;
        return r;
    }

    public static Result success(String msg, Object data) {
        Result r = new Result();
        r.success = true;
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static Result error(String msg) {
        Result r = new Result();
        r.success = false;
        r.msg = msg;
        return r;
    }

    // getter & setter
    public boolean isSuccess() {return success;}
    public String getMsg() {return msg;}
    public Object getData() {return data;}
}