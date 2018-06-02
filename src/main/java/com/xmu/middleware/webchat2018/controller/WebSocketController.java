package com.xmu.middleware.webchat2018.controller;

import com.xmu.middleware.webchat2018.model.ContactHistory;
import com.xmu.middleware.webchat2018.model.InMessage;
import com.xmu.middleware.webchat2018.servcie.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @Autowired
    private WebSocketService ws;




    @MessageMapping("/single/chat")
    public void singleChat(InMessage message) {
        System.out.println("MessageMapping" + message.toString());

        ContactHistory history=new ContactHistory(message.getFrom(),message.getTo(),message.getTime(),message.getContent());
        ws.sendMessageToDatabase(history);
        ws.sendChatMessage(message);

    }

}
