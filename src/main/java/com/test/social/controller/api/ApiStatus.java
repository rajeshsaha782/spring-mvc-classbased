package com.test.social.controller.api;

import org.springframework.http.HttpStatus;

public class ApiStatus {
    private HttpStatus code;
    private String message;
    private Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiStatus() {
    }

    public ApiStatus(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiStatus(HttpStatus code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
