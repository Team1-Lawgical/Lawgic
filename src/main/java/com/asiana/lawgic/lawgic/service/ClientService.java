package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.entity.Client;

import java.util.Optional;

public interface ClientService {
    // 이메일 중복 체크
<<<<<<< HEAD
    public boolean emailExists(String inputEmail);


=======
    public String emailExists(String inputEmail);

    public void insertClient(ClientDTO clientDTO);

    public Optional<Client> findClientByEmail(String inputEmail);
>>>>>>> 494cddd2facd44c4ba5c0a59aa0abd734b85e28e
}
