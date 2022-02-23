package com.asiana.lawgic.lawgic.controller;

import com.asiana.lawgic.lawgic.converter.ConsultConverter;
import com.asiana.lawgic.lawgic.dto.ConsultDTO;
import com.asiana.lawgic.lawgic.repository.ChatRepository;
import com.asiana.lawgic.lawgic.service.ConsultServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsultController {

    private final ConsultServiceImpl consultService;

    public ConsultController(ConsultServiceImpl consultService) {
        this.consultService = consultService;
    }


    @PostMapping("/form/consult")
    @ResponseStatus(HttpStatus.CREATED)
    public String insertConsultation(ConsultDTO consultDTO, Model model) throws Exception {
        consultService.insertConsult(consultDTO);
        int chatId = 1; // 임시값
        model.addAttribute("chatId", chatId);
        return "chat/index";
    }


}
