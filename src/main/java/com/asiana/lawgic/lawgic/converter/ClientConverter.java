package com.asiana.lawgic.lawgic.converter;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {

    public ClientDTO convertToClientDTO(Client client) {
        return ClientDTO.builder()
                .clientId(client.getClientId())
                .password(client.getPassword())
                .name(client.getName())
                .email(client.getEmail())
                .address(client.getAddress())
                .birthday(client.getBirthday())
                .phone(client.getPhone())
                .gender(client.getGender())
                .carType(client.getCarType())
                .build();
    }
}
