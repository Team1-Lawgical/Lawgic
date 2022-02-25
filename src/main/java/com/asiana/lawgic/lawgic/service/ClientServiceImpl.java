package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.config.ModelMapperConfig;
import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String emailExists(String inputEmail) {
        Optional<Client> result = clientRepository.findClientByEmail(inputEmail);
        return (result.isPresent()) ? "fail" : "ok";
    }

    public Optional<Client> findClientByEmail(String inputEmail) {
        Optional<Client> result = clientRepository.findClientByEmail(inputEmail);
        return result;
    }


    public void insertClient(ClientDTO clientDTO) {
        ModelMapper mapper= ModelMapperConfig.getModelMapperInstance();
        Client client=Client.builder()
                .address(clientDTO.getAddress())
                .birthday(clientDTO.getBirthday())
                .carType(clientDTO.getCarType())
                .gender(clientDTO.getGender())
                .password(clientDTO.getPassword())
                .phone(clientDTO.getPhone())
                .email(clientDTO.getEmail())
                .name(clientDTO.getName())
                .build();
        Client client2 = mapper.map(clientDTO, Client.class);
        clientRepository.save(client);
    }
}