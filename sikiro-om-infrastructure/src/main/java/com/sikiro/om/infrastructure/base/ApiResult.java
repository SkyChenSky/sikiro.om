package com.sikiro.om.infrastructure.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Setter;

/**
 * API统一响应实体
 * @param <T> 业务实体
 */
public class ApiResult<T> {

    @ApiModelProperty(value = "状态码")
    @Setter(AccessLevel.PRIVATE)
    public int resultCode;

    @ApiModelProperty(value = "实体数据")
    @Setter(AccessLevel.PRIVATE)
    public T data;

    @ApiModelProperty(value = "提示")
    @Setter(AccessLevel.PRIVATE)
    public String message;

    @ApiModelProperty(value = "是否成功")
    @Setter(AccessLevel.PRIVATE)
    public boolean success;

    @ApiModelProperty(value = "是否失败")
    @Setter(AccessLevel.PRIVATE)
    public boolean failed;

    @ApiModelProperty(value = "是否异常")
    @Setter(AccessLevel.PRIVATE)
    public boolean error;

    public static <T> ApiResult<T> Success() {
        return Success(ApiResultCode.Succeed.Message(), null, ApiResultCode.Succeed.Value());
    }

    public static <T> ApiResult<T> Success(T data) {
        return Success(ApiResultCode.Succeed.Message(), data, ApiResultCode.Succeed.Value());
    }

    public static <T> ApiResult<T> Success(String msg) {
        return Success(msg, null);
    }

    public static <T> ApiResult<T> Success(String msg, T data, int code) {
        ApiResult<T> result = new ApiResult<>();
        result.setMessage(msg);
        result.setData(data);
        result.setResultCode(code);
        result.setSuccess(true);
        result.setFailed(false);
        result.setError(false);

        return result;
    }

    public static <T> ApiResult<T> Success(String msg, T data) {
        return Success(msg, data, ApiResultCode.Succeed.Value());
    }

    public static <T> ApiResult<T> Failed() {
        return Failed(ApiResultCode.Failed.Message(), null, ApiResultCode.Failed.Value());
    }

    public static <T> ApiResult<T> Failed(String msg) {
        return Failed(msg, null);
    }

    public static <T> ApiResult<T> Failed(String msg, T data) {
        return Failed(msg, data, ApiResultCode.Failed.Value());
    }

    public static <T> ApiResult<T> Failed(String msg, T data, int code) {
        ApiResult<T> result = new ApiResult<>();
        result.setMessage(msg);
        result.setData(data);
        result.setResultCode(code);

        result.setSuccess(false);
        result.setFailed(true);
        result.setError(false);

        return result;
    }

    public static <T> ApiResult<T> Error(String msg) {
        ApiResult<T> result = new ApiResult<>();
        result.setMessage(msg);
        result.setResultCode(ApiResultCode.Error.Value());

        result.setSuccess(false);
        result.setFailed(true);
        result.setError(true);

        return result;
    }
}
