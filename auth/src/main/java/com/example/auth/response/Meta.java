package com.example.auth.response;

import java.io.Serializable;

public class Meta extends BaseResponse implements Serializable {

    public int errorCode;
    public String errorDescription;
    public Meta() {
    }

    public Meta(int errorCode) {
        this.errorCode = errorCode;
    }

    public Meta(int errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDescription = errorDesc;
    }
}
