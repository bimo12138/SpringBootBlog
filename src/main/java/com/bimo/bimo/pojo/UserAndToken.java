package com.bimo.bimo.pojo;

public class UserAndToken {
    private User user;
    private String token;

    public UserAndToken(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserAndToken() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
