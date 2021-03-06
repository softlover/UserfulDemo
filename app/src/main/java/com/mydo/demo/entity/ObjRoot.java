package com.mydo.demo.entity;


/**
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class ObjRoot<T> {
    private int status;
    private String code;
    private String msg;
    private T content;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
