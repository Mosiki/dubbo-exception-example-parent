package io.github.mosiki.handler;

import io.github.mosiki.common.exception.ServiceException;
import io.github.mosiki.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 类名称：WingExceptionHandler
 * 类描述：异常处理器
 * 创建人：WeJan
 * 创建时间：2018年10月26日 10:36
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handlerServiceException(ServiceException ex) {
        return Result.failure(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public Result handlerException(Exception ex) {
        log.error("发生未知异常：{}", ex);
        return Result.failure(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器打了个小盹儿~请稍候再试");
    }
}
