package com.tom.dto;

public class WebApiOutput<TValue> extends OutputBase {
    private TValue resultValue;

    public TValue getResultValue() {
        return resultValue;
    }

    private WebApiOutput(boolean success, String message, TValue resultValue) {
        super(success, message);
        this.resultValue = resultValue;
    }

    //成功
    public static <TValue> WebApiOutput Success(TValue resultValue) {
        return new WebApiOutput(true, "", resultValue);
    }

    //成功
    public static <TValue> WebApiOutput Success(TValue resultValue, String message) {
        return new WebApiOutput(true, message, resultValue);
    }
}
