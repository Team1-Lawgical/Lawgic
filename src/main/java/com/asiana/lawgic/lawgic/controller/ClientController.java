package com.asiana.lawgic.lawgic.controller;

//import com.asiana.lawgic.lawgic.dto.LawyerDTO;
//import com.asiana.lawgic.lawgic.dto.MessageDTO;
import com.asiana.lawgic.lawgic.service.ChatService;
import com.asiana.lawgic.lawgic.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class ClientController {

    private final ClientService clientService;
    private final ChatService chatService;

//    @GetMapping("/login")
//    public String mainClientController(Model model) {
//        //service에서 clientDTO를 얻어오는 코드가 있다는 가정
//        ClientDTO clientDTO = chatService.getClientInfo();
//        model.addAttribute("dto", clientDTO);
//
//        return "/client/login";
//    }

    @GetMapping("/")
    public String login(String email, String password) {

        return "client/login";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "client/signupForm";
    }

}
