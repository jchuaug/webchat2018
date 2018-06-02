package com.xmu.middleware.webchat2018.model;



public class OutMessage {
    private String to;
    private String from;
    private String content;
    private String time;

    @Override
    public String toString() {
        return "OutMessage{" +
                "form='" + from + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    public OutMessage() {
    }

    public OutMessage(String content) {
        this.content = content;
    }

    public OutMessage(String content, String time) {
        this.content = content;
        this.time = time;
    }

    public OutMessage(String to, String from, String content, String time) {
        this.to = to;
        this.from = from;
        this.content = content;
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
