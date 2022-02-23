package com.asiana.lawgic.lawgic.controller;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.dto.LawyerDTO;
import com.asiana.lawgic.lawgic.dto.MessageDTO;
import com.asiana.lawgic.lawgic.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@RequiredArgsConstructor
@Controller
public class ChatController {

    final private ChatService chatService;
    final private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/chat/client")
    public String mainClientChatController(Model model){
        //service에서 clientDTO를 얻어오는 코드가 있다는 가정
        ClientDTO clientDTO=chatService.getClientInfo();
        MessageDTO messageDTO=chatService.getClientMessage();
        model.addAttribute("dto",clientDTO);
        model.addAttribute("message",messageDTO);

        return "chat/chat";
    }
    @GetMapping("/chat/lawyer")
    public String mainLawyerChatController(LawyerDTO lawyerDTO){

        return "chat/chat";
    }

    @GetMapping("/")
    public String mainClientChatController3(Model model){
        //service에서 clientDTO를 얻어오는 코드가 있다는 가정
        ClientDTO clientDTO=chatService.getClientInfo();
        MessageDTO messageDTO=chatService.getClientMessage();
        model.addAttribute("dto",clientDTO);
        model.addAttribute("message",messageDTO);
        return "chat/chat";
    }




    // "/app"로 시작하는 대상이 있는 클라이언트에서 보낸 모든 메시지는
    // @MessageMapping 어노테이션이 달린 메서드로 라우팅 됩니다.
    // 예를 들어 "/app/chat.sendMessage"인 메시지는 sendMessage()로 라우팅 되며
    // "/app/chat.addUser"인 메시지는 addUser()로 라우팅된다.
    @MessageMapping("/chat.sendMessage")
     //@SendTo("/topic/public")
    public MessageDTO sendMessage(@Payload MessageDTO messageDTO){
        System.out.println("sendMessage method!!!***");
        System.out.println("message1:"+messageDTO.getContent());
        System.out.println("sender1:"+messageDTO.getSender());
        simpMessagingTemplate.convertAndSend("/topic/public",messageDTO);
        return messageDTO;
    }
}
