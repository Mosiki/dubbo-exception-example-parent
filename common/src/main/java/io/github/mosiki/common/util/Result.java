package io.github.mosiki.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.mosiki.common.status.ErrorStatus;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4189242674036256460L;
    private boolean success;
    private Integer code = 0;
    private String message;

    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
        this.success = true;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    public static Result<?> success() {
        Result<?> Result = new Result<>();
        Result.setSuccess(true);
        return Result;
    }

    public static Result<?> failure() {
        Result<?> Result = new Result<>();
        Result.setSuccess(false);
        return Result;
    }

    public static Result<?> failure(String message) {
        Result<?> Result = new Result<>();
        Result.setSuccess(false);
        Result.setMessage(message);
        return Result;
    }

    public static <T> Result<T> failure(ErrorStatus error) {
        return failure(error.getCode(), error.getDesc());
    }

    public static <T> Result<T> failure(Integer code, String message) {
        Result<T> res = new Result<>();
        res.setSuccess(false);
        res.setMessage(message);
        res.setCode(code);
        return res;
    }
}
