package com.asiana.lawgic.lawgic.controller;

import com.asiana.lawgic.lawgic.dto.MessageDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRestController {
    @PostMapping("/message")
    public String saveMessage(@RequestBody String chatId){
        System.out.println("여기 호출!!!");
        System.out.println("아이디:"+chatId);

        return "ok";
    }
}
