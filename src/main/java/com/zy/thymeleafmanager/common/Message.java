package com.zy.thymeleafmanager.common;

import java.io.Serializable;

public class Message<T> implements Serializable {

    private static final long serialVersionUID = -4216728063077339316L;
    private int code;
    private String message;
    private T data;
    private boolean success;

    public Message() {
    }

    public Message(int code, String message, T data, boolean success) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public Message<T> success(T data) {
        return new Message<>(Codes.SUCCESS, "ok", data, true);
    }

    public Message<T> fail(int code, String message) {
        return new Message<>(Codes.FAIL, message, null, false);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public interface Codes {
        int SUCCESS = 0;
        int FAIL = 999;
    }
}
