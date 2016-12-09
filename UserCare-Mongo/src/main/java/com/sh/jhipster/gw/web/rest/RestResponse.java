package com.sh.jhipster.gw.web.rest;

/**
 * Created by Faiziev Shuhrat on 11/29/16.
 */
public class RestResponse<T> {
    private int code=200;
    private String status;
    private T data;

    public RestResponse(int code, String status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
