package com.xmu.middleware.webchat2018.model;

import java.util.Date;

public class OutMessage {
    private String form;
    private String content;
    private String time;

    @Override
    public String toString() {
        return "OutMessage{" +
                "form='" + form + '\'' +
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

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
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
