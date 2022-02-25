package com.asiana.lawgic.lawgic.controller;

import com.asiana.lawgic.lawgic.dto.ConsultDTO;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.entity.Lawyer;
import com.asiana.lawgic.lawgic.service.ConsultServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ConsultController {

    private final ConsultServiceImpl consultService;

    public ConsultController(ConsultServiceImpl consultService) {
        this.consultService = consultService;
    }

    @GetMapping("/consult")
    public String readConsultationPage(@RequestParam("clientId") Long clientId,
                                       @RequestParam("lawyerId") Long lawyerId, Model model) throws Exception {
        Client client = consultService.getClientById(clientId);
        Lawyer lawyer = consultService.getLawyerById(lawyerId);
        model.addAttribute("client", client);
        model.addAttribute("lawyer", lawyer);
        return "form/consult";
    }

    @PostMapping("/consult/insert-consult")
    public String insertConsultation(ConsultDTO consultDTO) throws Exception {
        consultDTO.setClientId(1L);
        consultDTO.setLawyerId(1L);
        consultService.insertConsult(consultDTO);
        return "chat/index";
    }
}
