package com.dxb.oauth.customadpter.utils;

import lombok.Data;

/**
 * 响应工具类
 */
@Data
public class Response<T> {
    Integer code;
    String msg;
    T data;

    public Response() {
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public Response ok(String msg) {
        return new Response(200, msg);
    }

    public Response ok(T data) {
        return new Response<>(200, "成功", data);
    }

    public Response<T> ok(String msg, T data) {
        return new Response<>(200, msg, data);
    }

    public Response<T> err(String msg) {
        return new Response<>(500, msg);
    }

    public Response<T> err(Integer code, String msg) {
        return new Response<>(code, msg);
    }

    public Response<T> err(String msg, T data) {
        return new Response<>(500, msg, data);
    }

    public Response<T> err(Integer code, String msg, T data) {
        return new Response<>(code, msg, data);
    }

}
