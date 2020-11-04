package com.sikiro.om.infrastructure.base;

/**
 * 服务方法通用返回
 * @param <T>
 */
public class ServiceResult<T> {

    /**
     * 结果码
     */
    private ServiceResultCode _resultCode;

    /**
     * 返回消息
     */
    private String _message;

    /**
     * 返回异常
     */
    private Exception _exception;

    /**
     * 返回数据结果
     */
    private T _data;

    public T getData() {
        return _data;
    }

    public String getMessage() {
        return _message;
    }

    public Exception getException() {
        return _exception;
    }

    public ServiceResult(String msg, ServiceResultCode resultCode) {
        _message = msg;
        _resultCode = resultCode;
    }

    public ServiceResult(String msg, ServiceResultCode resultCode, T data) {
        _message = msg;
        _resultCode = resultCode;
        _data = data;
    }

    public ServiceResult(Exception ex, ServiceResultCode resultCode) {
        _exception = ex;
        _resultCode = resultCode;
    }

    /**
     * 是否成功
     * @return
     */
    public boolean IsSuccessd() {
        return _resultCode == ServiceResultCode.Succeed;
    }

    /**
     * 是否异常
     * @return
     */
    public boolean IsError() {
        return _resultCode == ServiceResultCode.Error;
    }

    /**
     * 是否失败
     * @return
     */
    public boolean IsFailed() {
        return _resultCode == ServiceResultCode.Error || _resultCode == ServiceResultCode.Failed;
    }

    public static <T> ServiceResult Success(String msg) {
        return new ServiceResult(msg, ServiceResultCode.Succeed);
    }

    public static <T> ServiceResult Success(String msg, T data) {
        return new ServiceResult(msg, ServiceResultCode.Succeed, data);
    }

    public static ServiceResult Error(Exception ex) {
        return new ServiceResult(ex, ServiceResultCode.Error);
    }

    public static ServiceResult Failed(String msg) {
        return new ServiceResult(msg, ServiceResultCode.Failed);
    }

    public static <T> ServiceResult Failed(String msg, T data) {
        return new ServiceResult(msg, ServiceResultCode.Failed, data);
    }
}
