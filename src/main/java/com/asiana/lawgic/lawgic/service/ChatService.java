package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.dto.LawyerDTO;
import com.asiana.lawgic.lawgic.dto.MessageDTO;
import com.asiana.lawgic.lawgic.entity.Consult;
import com.asiana.lawgic.lawgic.entity.Message;

import java.util.List;

public interface ChatService {
    public List<LawyerDTO> getAllLawyers();
    public List<ClientDTO> getClientsByLawyerId(Long lawyerId);
    public List<LawyerDTO> getLawyersByClientId(Long clientID);
    public MessageDTO getClientMessage();
    public Consult getConsultByLawyerAndClientId(Long lawyerId, Long clientID);
    public List<MessageDTO> getMessageByChatId(Long chatId);
    public Long getChatId(Consult consult);
    public void saveMessage(MessageDTO messageDTO);
}