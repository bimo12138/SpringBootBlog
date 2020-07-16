package com.bimo.bimo.pojo;

import com.alibaba.fastjson.JSON;

public class Message {
    public static final String Enter = "ENTER";
    public static final String SPEAK = "SPEAK";
    public static final String QUIT = "QUIT";

    private String type;
    private String username;
    private String message;
    private int onlineCount;

    public Message() {
    }

    public Message(String type, String username, String message, int onlineCount) {
        this.type = type;
        this.username = username;
        this.message = message;
        this.onlineCount = onlineCount;
    }

    public static String joinStr(String type, String username, String message, int onlineCount) {
        return JSON.toJSONString(new Message(type, username, message, onlineCount));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }
}
