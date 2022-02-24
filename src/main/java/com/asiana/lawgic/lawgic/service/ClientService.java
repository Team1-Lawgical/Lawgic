package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.dto.ClientDTO;

public interface ClientService {
//    public ClientDTO getClientInfo();
    // 이메일 중복 체크
    public boolean emailExists(String inputEmail);
}
