package io.github.mosiki.common.status;

import lombok.Getter;

/**
 * 类名称：EnumBaseError
 * 类描述：公用枚举
 * 创建人：WeJan
 * 创建时间：2018年10月26日 10:24
 */
@Getter
public enum EnumBaseError implements ErrorStatus {
    /**
     * 缺少必要请求参数
     */
    MISSING_PARAMETERS(400, "missing_required_parameters"),

    /**
     * 非法请求参数
     */
    ILLEGAL_PARAMETER(401, "illegal_request_parameter"),

    /**
     * 服务器内部异常
     */
    INTERNAL_EXCEPTION(500, "server_internal_exception"),
    ;

    private Integer code;

    private String desc;

    EnumBaseError(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
