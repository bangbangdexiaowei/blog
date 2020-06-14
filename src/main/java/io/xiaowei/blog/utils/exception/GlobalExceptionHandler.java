package io.xiaowei.blog.utils.exception;

import io.xiaowei.blog.utils.http.HttpResult;
import io.xiaowei.blog.utils.http.HttpStatus;
import io.xiaowei.blog.utils.http.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import static javafx.scene.input.KeyCode.R;

/**
 * 异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public HttpResult handleRRException(BusinessException e) {
        HttpResult r = new HttpResult();
        r.setCode(e.getCode());
        r.setMessage(e.getMessage());
        return r;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public HttpResult handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return ResultGenerator.genFailResult(HttpStatus.SC_NOT_FOUND, "路径不存在，请检查路径是否正确");
    }

//    @ExceptionHandler(DuplicateKeyException.class)
//    public R handleDuplicateKeyException(DuplicateKeyException e) {
//        logger.error(e.getMessage(), e);
//        return R.error("数据库中已存在该记录");
//    }

//    @ExceptionHandler(AuthorizationException.class)
//    public R handleAuthorizationException(AuthorizationException e) {
//        logger.error(e.getMessage(), e);
//        return R.error("没有权限，请联系管理员授权");
//    }

    @ExceptionHandler(Exception.class)
    public HttpResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResultGenerator.genFailResult(HttpStatus.SC_INTERNAL_SERVER_ERROR, "服务异常");
    }
}
