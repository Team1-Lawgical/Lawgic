package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.converter.ClientConverter;
import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;

    public ClientServiceImpl(ClientRepository clientRepository, ClientConverter clientConverter) {
        this.clientRepository = clientRepository;
        this.clientConverter = clientConverter;
    }

    @Override
    @Transactional
    public ClientDTO getClientById(Long clientId) throws Exception {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new Exception("해당 id의 고객이 없습니다"));
        return ClientDTO.builder()
                .name(client.getName())
                .password(client.getPassword())
                .birthday(client.getBirthday())
                .email(client.getEmail())
                .address(client.getAddress())
                .phone(client.getPhone())
                .carType(client.getCarType())
                .gender(client.getGender())
                .build();
    }
}
