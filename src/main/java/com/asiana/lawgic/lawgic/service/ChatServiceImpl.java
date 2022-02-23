package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.config.ModelMapperConfig;
import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.dto.LawyerDTO;
import com.asiana.lawgic.lawgic.dto.MessageDTO;
import com.asiana.lawgic.lawgic.entity.*;
import com.asiana.lawgic.lawgic.repository.ChatRepository;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import com.asiana.lawgic.lawgic.repository.ConsultRepository;
import com.asiana.lawgic.lawgic.repository.LawyerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {
    final private LawyerRepository lawyerRepository;
    final private ConsultRepository consultRepository;
    final private ChatRepository chatRepository;

    public List<LawyerDTO> getAllLawyers() {
        ModelMapper mapper = ModelMapperConfig.getModelMapperInstance();

        Object[] lawyers = lawyerRepository.getAllLawyers();
        List<Lawyer> lawyerList = new ArrayList<>();
        List<LawyerDTO> lawyerDTOList = new ArrayList<>();
        for (Object o : lawyers) {
            lawyerList.add((Lawyer) o);
        }

        for (Lawyer lawyerEntity : lawyerList) {
            LawyerDTO lawyerDTO = mapper.map(lawyerEntity, LawyerDTO.class);
            lawyerDTOList.add(lawyerDTO);
        }

        return lawyerDTOList;

    }

    public MessageDTO getClientMessage() {
        MessageDTO messageDTO = MessageDTO.builder()
                .content("내용 1")
                .sender("Client")
                .regdate("2022-03-12")
                .build();
        return messageDTO;
    }

    @Override
    public Consult getConsultByLawyerAndClientId(Long lawyerId, Long clientID) {
        Consult consult = consultRepository.getConsultByLawyerAndClientId(lawyerId, clientID);
        return consult;
    }

    @Override
    public List<MessageDTO> getMessageByChatId(Long chatId) {
        ModelMapper mapper = ModelMapperConfig.getModelMapperInstance();
        Chat chat = chatRepository.getMessagesByChatId(21L);
        List<Message> messages = chat.getMessages();
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for (Message m : messages) {
            MessageDTO messageDTO = mapper.map(messages, MessageDTO.class);
            messageDTOList.add(messageDTO);
        }


        return messageDTOList;
    }

    @Override
    public Long getChatId(Consult consult) {
        Long chatId = chatRepository.getChatIdByLawyerAndClientId(consult.getLawyer().getLawyerId(), consult.getClient().getClientId());
        return chatId;
    }


}
