package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.converter.ClientConverter;
import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean emailExists(String inputEmail) {
        Optional<Client> result = clientRepository.findClientByEmail("naver");
        if (result.isPresent()) {
            System.out.println("사용할 수 없는 이메일");
            return true;
        } else {
            System.out.println("사용가능한 이메일");
            return false;
        }
    }

    @Override
    public ClientDTO getClientById(Long clientId) throws Exception {
        return null;
    }

    public void insertClient(ClientDTO clientDTO) {


    }
}