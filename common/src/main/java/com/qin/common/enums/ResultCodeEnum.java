package com.qin.common.enums;

import lombok.Getter;

/**
 * @author qinch
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"操作成功"),
    NOT_FOUND(404,"找不到相关信息"),
    UNAUTHORIZED(403,"未授权"),
    ERROR(500,"发生错误"),
    INVALID_PARAM(400,"无效的参数");

    private int code;

    private String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
