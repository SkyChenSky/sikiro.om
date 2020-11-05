package com.sikiro.om.infrastructure.base;

public enum ApiResultCode {

    Succeed(200,"请求成功"),
    Failed(400,"请求失败"),
    Error(500,"服务执行异常");

    private int _index;
    private String _msg;

    ApiResultCode(int index, String msg) {
        _index = index;
        _msg = msg;
    }

    public int Value() {
        return _index;
    }
    public String Message() {
        return _msg;
    }

}
