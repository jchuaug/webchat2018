package com.xmu.middleware.webchat2018.model;

import java.math.BigInteger;

public class ContactHistory implements  Comparable<ContactHistory> {
    private  BigInteger id;
    private String from;
    private String to;
    private String timestamp;
    private String content;

    public ContactHistory() {
    }

    public ContactHistory(BigInteger id,String from, String to, String timestamp,String content) {
        this.id=id;
        this.from = from;
        this.to = to;
        this.timestamp = timestamp;
        this.content=content;
    }
    public ContactHistory(String from, String to, String timestamp,String content) {
        this.from = from;
        this.to = to;
        this.timestamp = timestamp;
        this.content=content;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int compareTo(ContactHistory o) {
        if(this.id.longValue()>o.getId().longValue()){
            return 1;
        }
        if(this.id.longValue()<o.getId().longValue()){
            return -1;
        }
        return 0;
    }
}
