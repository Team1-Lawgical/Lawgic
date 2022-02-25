package com.asiana.lawgic.lawgic;

import com.asiana.lawgic.lawgic.entity.*;
import com.asiana.lawgic.lawgic.repository.ChatRepository;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import com.asiana.lawgic.lawgic.repository.ConsultRepository;
import com.asiana.lawgic.lawgic.repository.LawyerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ChatRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LawyerRepository lawyerRepository;
    @Autowired
    private ConsultRepository consultRepository;
    @Autowired
    private ChatRepository chatRepository;
    private String[] send={"client","lawyer","client","lawyer","client","client","lawyer","client","lawyer","client"};

    @Test
    public void chatDataInsert() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            Object[] clients = clientRepository.getAllClients();
            Object[] lawyers = lawyerRepository.getAllLawyers();
            Object[] consults = consultRepository.getAllConsults();
            List<Message> messages=new ArrayList<>();
            IntStream.rangeClosed(1, 10).forEach(k -> {
                Message message=Message.builder()
                        .content("message content "+k)
                        .type(MessageType.CHAT)
                        .sender(send[k-1])
                        .regDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("Asia/Seoul")))
                        .receiver(send[k-1].equals("client")?"lawyer":"client")
                        .build();
                messages.add(message);
            });
            Chat chat = Chat.builder()
                    .client((Client) clients[i - 1])
                    .lawyer((Lawyer) lawyers[i - 1])
                    .consult((Consult) consults[i - 1])
                    .messages(messages)
                    .build();
            chatRepository.save(chat);

        });

    }

    @Test
    public void getChatIdTest() {
        Long chatId=chatRepository.getChatIdByLawyerAndClientId(6L, 1L);
        System.out.println("chatId:"+chatId);
    }

    @Test
    public void getMessageByChatIdTest(){
        Chat chat=chatRepository.getMessagesByChatId(21L);
        System.out.println(chat.getMessages().get(0).getContent());
    }



}
