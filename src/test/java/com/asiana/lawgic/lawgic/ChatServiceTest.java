package com.asiana.lawgic.lawgic;

import com.asiana.lawgic.lawgic.dto.MessageDTO;
import com.asiana.lawgic.lawgic.entity.Chat;
import com.asiana.lawgic.lawgic.entity.Message;
import com.asiana.lawgic.lawgic.repository.ChatRepository;
import com.asiana.lawgic.lawgic.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ChatServiceTest {
    @Autowired
    ChatService chatService;

    @Test
    public void getMessagesServiceTest(){
        Object chat=chatService.getMessageByChatId(21L);
        Chat c=(Chat)chat;
        List<Message> message=c.getMessages();
        for(Message m:message){
            System.out.println(m.getContent());
        }
    }
}
