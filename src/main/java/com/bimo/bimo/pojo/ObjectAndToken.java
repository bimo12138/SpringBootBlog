package com.bimo.bimo.pojo;

public class ObjectAndToken {
    private Object object;
    private String token;

    public ObjectAndToken(Object object, String token) {
        this.object = object;
        this.token = token;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
