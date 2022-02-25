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

<<<<<<< HEAD
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

    public void insertClient(ClientDTO clientDTO) {

=======
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
        System.out.println("client:"+client.getClientId());
        System.out.println("client:"+client.getEmail());
        System.out.println("client:"+client.getPassword());
        System.out.println("client:"+client.getName());
        System.out.println("client:"+client.getPhone());
        clientRepository.save(client);
>>>>>>> 494cddd2facd44c4ba5c0a59aa0abd734b85e28e
    }
}