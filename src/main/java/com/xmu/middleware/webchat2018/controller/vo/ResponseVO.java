package com.xmu.middleware.webchat2018.controller.vo;

import com.xmu.middleware.webchat2018.model.User;

public class ResponseVO {
    private Integer statusCode;
    private String url;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getUrl() {
        return url;
    }



    public void setUrl(String url) {
        this.url = url;
    }



    public ResponseVO() {

    }

    public ResponseVO(Integer statusCode, String url,User user) {
        this.statusCode = statusCode;
        this.url = url;
        this.user=user;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "statusCode=" + statusCode +
                ", url='" + url + '\'' +
                ", user=" + user +
                '}';
    }
}
