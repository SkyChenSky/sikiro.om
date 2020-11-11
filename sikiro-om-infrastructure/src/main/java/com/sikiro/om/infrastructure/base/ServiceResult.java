package com.sikiro.om.infrastructure.base;

import com.sikiro.om.infrastructure.helper.ModelMapperHelper;
import lombok.Getter;

/**
 * 服务方法通用返回
 * @param <T>
 */
@SuppressWarnings("ALL")
public class ServiceResult<T> {

    /**
     * 结果码
     */
    private ServiceResultCode resultCode;

    /**
     * 返回消息
     */
    @Getter
    private String message;

    /**
     * 返回异常
     */
    @Getter
    private Exception exception;

    /**
     * 返回数据结果
     */
    @Getter
    private T data;

    public ServiceResult(String msg, ServiceResultCode rc) {
        message = msg;
        resultCode = rc;
    }

    public ServiceResult(String msg, ServiceResultCode rc, T d) {
        message = msg;
        resultCode = rc;
        data = d;
    }

    /**
     * 是否成功
     *
     * @return 是否成功
     */
    public boolean IsSuccessd() {
        return resultCode == ServiceResultCode.Succeed;
    }

    /**
     * 是否失败
     *
     * @return 是否失败
     */
    public boolean IsFailed() {
        return resultCode == ServiceResultCode.Failed;
    }

    /**
     * 返回成功
     *
     * @param <T> 业务参数
     * @return ServiceResult
     */
    public static <T> ServiceResult Success() {
        return new ServiceResult<T>(ServiceResultCode.Succeed.Message(), ServiceResultCode.Succeed);
    }

    /**
     * 返回成功
     *
     * @param msg 成功信息
     * @param <T> 业务参数
     * @return ServiceResult
     */
    public static <T> ServiceResult<T> Success(String msg) {
        return new ServiceResult<T>(msg, ServiceResultCode.Succeed);
    }

    /**
     * 返回成功
     *
     * @param msg  成功信息
     * @param data 业务数据
     * @param <T>  业务参数
     * @return ServiceResult
     */
    public static <T> ServiceResult<T> Success(String msg, T data) {
        return new ServiceResult<>(msg, ServiceResultCode.Succeed, data);
    }

    /**
     * 返回失败
     *
     * @return ServiceResult
     */
    public static ServiceResult Failed() {
        return new ServiceResult<>(ServiceResultCode.Failed.Message(), ServiceResultCode.Failed);
    }

    /**
     * 返回失败
     *
     * @param msg 失败信息
     * @return ServiceResult
     */
    public static <T> ServiceResult<T> Failed(String msg) {
        return new ServiceResult<>(msg, ServiceResultCode.Failed);
    }

    /**
     * 返回失败
     *
     * @param msg  提示
     * @param data 数据
     * @param <T>  业务数据实体
     * @return ServiceResult
     */
    public static <T> ServiceResult<T> Failed(String msg, T data) {
        return new ServiceResult<>(msg, ServiceResultCode.Failed, data);
    }

    /**
     * 转换ApiResult
     * @return
     */
    public ApiResult ToApiResult() {
        return this.IsSuccessd() ?
                ApiResult.Success(this.getMessage(), this.getData()) :
                ApiResult.Failed(this.getMessage(), this.getData());
    }

    /**
     * 转换ApiResult
     * @param classT
     * @param <T>
     * @return
     */
    public <T> ApiResult<T> ToApiResult(Class<T> classT) {
        T data = ModelMapperHelper.Map(this.getData(), classT);
        return this.IsSuccessd() ?
                ApiResult.Success(this.getMessage(), data) :
                ApiResult.Failed(this.getMessage(), data);
    }
}
