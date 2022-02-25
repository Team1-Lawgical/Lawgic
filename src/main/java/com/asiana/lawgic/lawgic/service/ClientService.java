package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.entity.Client;

import java.util.Optional;

public interface ClientService {
    // 이메일 중복 체크
    public String emailExists(String inputEmail);

    public void insertClient(ClientDTO clientDTO);

    public Optional<Client> findClientByEmail(String inputEmail);
}
