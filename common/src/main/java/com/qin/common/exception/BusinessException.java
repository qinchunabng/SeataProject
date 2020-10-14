package com.qin.common.exception;

/**
 * @author qinch
 */
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -6821703078124009215L;

    private Integer code;

    private String msg;

    public BusinessException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
