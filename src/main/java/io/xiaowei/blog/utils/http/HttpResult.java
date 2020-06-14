package io.xiaowei.blog.utils.http;

import lombok.Getter;

import lombok.Setter;

import java.io.Serializable;


@Setter

@Getter

public class HttpResult implements Serializable {

    private int code = HttpStatus.SC_OK;

    private String message;

    private Object data;

}