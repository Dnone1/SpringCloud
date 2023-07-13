package com.java.springCloud.domain;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code ;
    private String msg ;
    private  T date ;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public static Result error(Integer code , String msg) {
        return new Result(code , msg);
    }
}
