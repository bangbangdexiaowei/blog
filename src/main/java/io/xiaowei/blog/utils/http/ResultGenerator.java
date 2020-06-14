package io.xiaowei.blog.utils.http;

public class ResultGenerator {


    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";


    public static HttpResult genSuccessResult() {


        HttpResult result = new HttpResult();

        result.setCode(HttpStatus.SC_OK);

        result.setMessage(DEFAULT_SUCCESS_MESSAGE);


        return result;

    }


    public static HttpResult genSuccessResult(Object data) {


        HttpResult result = new HttpResult();

        result.setCode(HttpStatus.SC_OK);

        result.setMessage(DEFAULT_SUCCESS_MESSAGE);

        result.setData(data);


        return result;

    }


    public static HttpResult genFailResult(String message) {


        HttpResult result = new HttpResult();

        result.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

        result.setMessage(message);


        return result;

    }


    public static HttpResult genFailResult(int resultCode, String message) {

        HttpResult result = new HttpResult();

        result.setCode(resultCode);

        result.setMessage(message);

        return result;

    }
}