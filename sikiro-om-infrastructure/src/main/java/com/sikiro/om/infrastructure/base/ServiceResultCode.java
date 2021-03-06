package com.sikiro.om.infrastructure.base;

public enum ServiceResultCode {
    Failed(0,"失败"),
    Succeed(1,"成功");

    private int _index;
    private String _msg;

    ServiceResultCode(int index, String msg) {
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
