package com.asiana.lawgic.lawgic.controller;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.dto.LawyerDTO;
import com.asiana.lawgic.lawgic.dto.MessageDTO;
import com.asiana.lawgic.lawgic.entity.Consult;
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

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {

    final private ChatService chatService;
    final private SimpMessagingTemplate simpMessagingTemplate;


    @GetMapping("/chat/client")
    public String mainClientChatController(Model model) {
        List<LawyerDTO> lawyerDTOList = chatService.getAllLawyers();
        MessageDTO messageDTO = chatService.getClientMessage();
        Consult consult = chatService.getConsultByLawyerAndClientId(6L, 1L);
        List<MessageDTO> messageDTOList = chatService.getMessageByChatId(21L);
        model.addAttribute("sender", "client");
        model.addAttribute("receiver", "lawyer");
        model.addAttribute("lawyerDTO", lawyerDTOList);
        model.addAttribute("message", messageDTO);
        model.addAttribute("chatLawyer", consult.getLawyer());
        model.addAttribute("messageList", messageDTOList);

        return "chat/chat";
    }

    @GetMapping("/chat/lawyer")
    public String mainLawyerChatController(Model model) {
        model.addAttribute("sender", "lawyer");
        model.addAttribute("receiver", "client");
        return "chat/chat";
    }

    @GetMapping("/")
    public String mainClientChatController3(Model model) {
        //service에서 clientDTO를 얻어오는 코드가 있다는 가정
//        ClientDTO clientDTO=chatService.getClientInfo();
//        MessageDTO messageDTO=chatService.getClientMessage();
//        model.addAttribute("dto",clientDTO);
//        model.addAttribute("message",messageDTO);
        model.addAttribute("sender", "lawyer");
        model.addAttribute("receiver", "client");
        return "chat/test";
    }


    // "/app"로 시작하는 대상이 있는 클라이언트에서 보낸 모든 메시지는
    // @MessageMapping 어노테이션이 달린 메서드로 라우팅 됩니다.
    // 예를 들어 "/app/chat.sendMessage"인 메시지는 sendMessage()로 라우팅 되며
    // "/app/chat.addUser"인 메시지는 addUser()로 라우팅된다.
    @MessageMapping("/chat.sendMessage")
    //@SendTo("/topic/public")
    public MessageDTO sendMessage(@Payload MessageDTO messageDTO) {
        System.out.println("sendMessage method!!!***");
        System.out.println("message1:" + messageDTO.getContent());
        messageDTO.setSender(messageDTO.getSender().equals("lawyer") ? "client" : "lawyer");
        simpMessagingTemplate.convertAndSend("/topic/public", messageDTO);
        return messageDTO;
    }
}
