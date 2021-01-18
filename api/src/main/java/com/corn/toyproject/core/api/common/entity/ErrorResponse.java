package com.corn.toyproject.core.api.common.entity;

public class ErrorResponse implements Response{
    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
