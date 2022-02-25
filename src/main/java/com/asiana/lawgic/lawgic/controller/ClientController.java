package com.asiana.lawgic.lawgic.controller;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.service.ChatService;
import com.asiana.lawgic.lawgic.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/client")
    public String home() {
        return "client/login";
    }

//    @GetMapping("/client/login")
    @RequestMapping(value = "/client/login", method = RequestMethod.POST)
    public String login(Model model, String email, String password) {
        Optional<Client> result = clientService.findClientByEmail(email);
        if (!result.isPresent()) {
            return "client/login_fail";
        }
        Client client = result.get();
        if (!client.getPassword().equals(password)) {
            System.out.println("비밀번호 틀림");
            return "client/login_fail";
        }
        else {
            model.addAttribute("clientId", client.getClientId());
            model.addAttribute("clientName", client.getName());
            return "client/test_consult";
        }
    }

    @GetMapping("/signupForm")
    public String signUpForm() {
        return "client/signupForm";
    }

    @RequestMapping("/client/checkAjax")
    @ResponseBody
    public String checkAjax(String id) {
        return clientService.emailExists(id);
    }

    @RequestMapping(value = "/client/insertClient", method = RequestMethod.POST)
    public String insertClient(Model model, ClientDTO cdto) {
        clientService.insertClient(cdto);
        model.addAttribute("clientName", cdto.getName());
        return "client/signup_ok";

    }



}
