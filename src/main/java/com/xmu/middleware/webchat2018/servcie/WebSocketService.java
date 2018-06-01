package com.xmu.middleware.webchat2018.servcie;

import com.xmu.middleware.webchat2018.model.InMessage;
import com.xmu.middleware.webchat2018.model.OutMessage;
import com.xmu.middleware.webchat2018.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate template;

    public void sendChatMessage(InMessage message){
        System.out.println("sendChatMessage--->"+message);
        template.convertAndSend("/chat/single/"+message.getTo(),
                new OutMessage(message.getContent(),message.getTime()));
    }

    public void sendTopicChat(InMessage message) {
        String msg = message.getContent();
        template.convertAndSend("/topic/chat",new OutMessage(msg));
    }


}
