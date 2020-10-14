package com.qin.common.domain;

import com.qin.common.enums.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qinch
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4406748630713172733L;

    private Integer code;

    private T data;

    private String msg;

    public Result(){

    }

    public Result(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static Result error(String msg){
        return new Result(ResultCodeEnum.ERROR.getCode(),null, msg);
    }

    public static <U> Result<U> success(U data){
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), data, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
