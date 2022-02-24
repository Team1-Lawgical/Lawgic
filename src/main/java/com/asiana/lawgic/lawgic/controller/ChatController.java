package com.asiana.lawgic.lawgic.controller;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.dto.LawyerDTO;
import com.asiana.lawgic.lawgic.dto.MessageDTO;
import com.asiana.lawgic.lawgic.entity.Consult;
import com.asiana.lawgic.lawgic.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {

    final private ChatService chatService;
    final private SimpMessagingTemplate simpMessagingTemplate;


    @GetMapping("/chat/client?id={id}")
    public String clientChatController(Model model, @PathVariable("id") String id) {
        List<LawyerDTO> lawyerDTOList = chatService.getLawyersByClientId(46L);
        Consult consult = chatService.getConsultByLawyerAndClientId(51L, 46L);
        model.addAttribute("sender", "client");
        model.addAttribute("receiver", "lawyer");
        model.addAttribute("DTO", lawyerDTOList);
        model.addAttribute("chatLawyer", consult.getLawyer());
        model.addAttribute("chatId", id);
        return "chat/chat_client";
    }

    @GetMapping("/chat/client")
    public String defaultClientChatController(Model model) {
        List<LawyerDTO> lawyerDTOList = chatService.getLawyersByClientId(46L);
        Consult consult = chatService.getConsultByLawyerAndClientId(51L, 46L);
        model.addAttribute("sender", "client");
        model.addAttribute("receiver", "lawyer");
        model.addAttribute("DTO", lawyerDTOList);
        model.addAttribute("chatLawyer", consult.getLawyer());

        return "chat/chat_client";
    }

    @GetMapping("/chat/lawyer?id={id}")
    public String lawyerChatController(Model model, @RequestParam Long id) {
        List<ClientDTO> clientDTOList = chatService.getClientsByLawyerId(51L);
        Consult consult = chatService.getConsultByLawyerAndClientId(51L, 46L);
        model.addAttribute("sender", "lawyer");
        model.addAttribute("receiver", "client");
        model.addAttribute("DTO", clientDTOList);
        model.addAttribute("chatClient", consult.getClient());
        model.addAttribute("chatId", id);
        return "chat/chat_lawyer";
    }

    @GetMapping("/chat/lawyer")
    public String defaultLawyerChatController(Model model) {
        List<ClientDTO> clientDTOList = chatService.getClientsByLawyerId(51L);
        Consult consult = chatService.getConsultByLawyerAndClientId(51L, 47L);
        model.addAttribute("sender", "lawyer");
        model.addAttribute("receiver", "client");
        model.addAttribute("DTO", clientDTOList);
        model.addAttribute("chatClient", consult.getClient());
        return "chat/chat_lawyer";
    }

    @GetMapping("/")
    public String mainClientChatController3(Model model) {
        model.addAttribute("sender", "lawyer");
        model.addAttribute("receiver", "client");
        return "chat/test";
    }


    @MessageMapping("/chat.sendMessage")
    public MessageDTO sendMessage(@Payload MessageDTO messageDTO) {
        System.out.println("content:" + messageDTO.getContent());
        System.out.println("sender:" + messageDTO.getSender());
        System.out.println("receiver:" + messageDTO.getReceiver());
        System.out.println("regdate:" + messageDTO.getRegdate());
        System.out.println("id:" + messageDTO.getChatId());
        chatService.saveMessage(messageDTO);
        simpMessagingTemplate.convertAndSend("/topic/public", messageDTO);
        return messageDTO;
    }

    @PostMapping("/message")
    public void saveMessage(@RequestBody MessageDTO messageDTO) {
        System.out.println("content:" + messageDTO.getContent());
        System.out.println("sender:" + messageDTO.getSender());
        System.out.println("receiver:" + messageDTO.getReceiver());
        System.out.println("regdate:" + messageDTO.getRegdate());
    }
}
