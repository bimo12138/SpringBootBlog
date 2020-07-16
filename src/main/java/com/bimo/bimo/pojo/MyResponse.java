package com.bimo.bimo.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class MyResponse implements Serializable {
    private Object response;
    private HttpStatus code;

    public MyResponse(Object response, HttpStatus code) {
        this.response = response;
        this.code = code;
    }

    public MyResponse(Object response) {
        this.response = response;
        this.code = HttpStatus.OK;
    }

    public MyResponse() {
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}
