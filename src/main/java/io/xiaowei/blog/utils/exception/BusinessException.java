package io.xiaowei.blog.utils.exception;

import io.xiaowei.blog.utils.http.HttpStatus;

/**
 * @Author xiaowei_wang
 * @Description 自定义异常
 * @Date 1:06 上午 2020/6/15
 * @Param
 * @return
 **/
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = HttpStatus.SC_INTERNAL_SERVER_ERROR;

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BusinessException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BusinessException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
