package io.github.mosiki.common.exception;

import io.github.mosiki.common.status.ErrorStatus;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 类名称：ServiceException
 * 类描述：业务异常
 * 创建人：WeJan
 * 创建时间：2018年10月26日 10:14
 */
@Slf4j
@Getter
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -6845028668264097201L;

    private Integer code;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(ErrorStatus errorStatus) {
        this(errorStatus.getCode(), errorStatus.getDesc());
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
