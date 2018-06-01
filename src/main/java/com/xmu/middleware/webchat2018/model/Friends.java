package com.xmu.middleware.webchat2018.model;

import java.math.BigInteger;

public class Friends {
    private BigInteger id;

    private BigInteger userId;

    private BigInteger friendId;
    public Friends(){}

    public Friends(BigInteger userId, BigInteger friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getFriendId() {
        return friendId;
    }

    public void setFriendId(BigInteger friendId) {
        this.friendId = friendId;
    }
}