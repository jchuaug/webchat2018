package com.xmu.middleware.webchat2018.model;

import java.util.Date;

public class InMessage {
    private String from;
    private String to;
    private String content;
    private String time;

    public InMessage() {
    }

    @Override
    public String toString() {
        return "InMessage{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    public InMessage(String content) {
        this.content = content;
    }

    public InMessage(String content, String time) {
        this.content = content;
        this.time = time;
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

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
