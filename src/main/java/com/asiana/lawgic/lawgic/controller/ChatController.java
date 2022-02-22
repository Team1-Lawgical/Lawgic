package com.asiana.lawgic.lawgic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @GetMapping("/chat")
    public String mainChatController(){
        return "chat/chat";
    }
}
