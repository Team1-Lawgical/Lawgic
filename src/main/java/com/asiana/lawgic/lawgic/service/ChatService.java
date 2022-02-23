package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.dto.MessageDTO;

public interface ChatService {
    public ClientDTO getClientInfo();
    public MessageDTO getClientMessage();
}
