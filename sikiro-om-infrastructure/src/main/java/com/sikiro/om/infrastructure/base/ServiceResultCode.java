package com.sikiro.om.infrastructure.base;

public enum ServiceResultCode {
    Error(-1), Failed(0), Succeed(1);

    private int _index;

    private ServiceResultCode(int index) {
        _index = index;
    }

    public int Value() {
        return _index;
    }

    public ServiceResultCode ValueOf(int index) {
        ServiceResultCode code;
        switch (index) {
            case -1:
                code = ServiceResultCode.Error;
                break;
            case 0:
                code = ServiceResultCode.Failed;
                break;
            case 1:
                code = ServiceResultCode.Succeed;
                break;
            default:code = ServiceResultCode.Error;
                break;
        }
        return code;
    }
}
