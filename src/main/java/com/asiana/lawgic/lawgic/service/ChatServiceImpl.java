package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.dto.MessageDTO;
import com.asiana.lawgic.lawgic.entity.CarType;
import com.asiana.lawgic.lawgic.entity.Message;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ChatServiceImpl implements ChatService{
    public ClientDTO getClientInfo(){
        ClientDTO clientDTO=ClientDTO.builder().clientId(1L)
                .address("경기도")
                .birthday(Date.valueOf("1995-03-16"))
                .carType(CarType.CITY_CAR)
                .email("youngkyon1324@naver.com")
                .name("유영균")
                .phone("010-3058-8541")
                .build();
        return clientDTO;

    }
    public MessageDTO getClientMessage(){
        MessageDTO messageDTO=MessageDTO.builder()
                .content("내용 1")
                .sender("Client")
                .date(Date.valueOf("2022-03-12"))
                .build();
        return messageDTO;
    }
}
