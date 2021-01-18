package com.corn.toyproject.core.api.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse implements Response{
    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "success";
    private final Object result;

    public SuccessResponse(Object result){
        this.result = result;
    }

    @Override
    @JsonProperty("code")
    public int getCode() {
        return SUCCESS_CODE;
    }

    @Override
    @JsonProperty("error")
    public String getMessage() {
        return SUCCESS_MESSAGE;
    }

    @JsonProperty("result")
    public Object getResult(){
        return result;
    }
}
