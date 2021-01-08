package com.atguigu.common.utils.exception;

public enum BizCodeEnum {
    VALID_EXCEPTION(400,"数据校验错误"),
    SERVER_EXCEPTION(500,"服务器错误");

    private Integer code;
    private String message;

    BizCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

