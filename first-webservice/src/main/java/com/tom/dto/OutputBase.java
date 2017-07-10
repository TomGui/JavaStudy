package com.tom.dto;

public class OutputBase {
    private boolean success;
    private String message;

    protected OutputBase(boolean success, String message) {
        this.success = success;
        this.message = message != null ? message : "";
    }

    // 成功
    public static OutputBase Success(String message) {
        return new OutputBase(true, message);
    }

    // 失败
    public static OutputBase Fail(String message) {
        return new OutputBase(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
