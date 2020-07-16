package com.bimo.bimo.dao;

public class Resultful {
    private int code;
    private String message;

    public Resultful() {
    }

    public Resultful(int code, String message) {
        this.code = code;
        this.message = message;
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
}
