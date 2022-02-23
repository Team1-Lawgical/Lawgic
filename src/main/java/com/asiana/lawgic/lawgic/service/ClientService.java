package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.dto.ClientDTO;

public interface ClientService {
    ClientDTO getClientById(Long clientId) throws Exception;
}
