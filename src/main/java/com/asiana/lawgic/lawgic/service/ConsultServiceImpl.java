package com.asiana.lawgic.lawgic.service;

import com.asiana.lawgic.lawgic.converter.ConsultConverter;
import com.asiana.lawgic.lawgic.dto.ConsultDTO;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.entity.Consult;
import com.asiana.lawgic.lawgic.entity.Lawyer;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import com.asiana.lawgic.lawgic.repository.ConsultRepository;
import com.asiana.lawgic.lawgic.repository.LawyerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultServiceImpl implements ConsultService {

    private final ConsultRepository consultRepository;
    private final LawyerRepository lawyerRepository;
    private final ClientRepository clientRepository;
    private final ConsultConverter converter;

    public ConsultServiceImpl(ConsultRepository consultRepository, LawyerRepository lawyerRepository, ClientRepository clientRepository, ConsultConverter converter) {
        this.consultRepository = consultRepository;
        this.lawyerRepository = lawyerRepository;
        this.clientRepository = clientRepository;
        this.converter = converter;
    }

    @Override
    @Transactional
    public Consult insertConsult(ConsultDTO consultDTO) throws Exception {
        getLawyerById(consultDTO.getClientId());
        getClientById(consultDTO.getLawyerId());
        Consult consult = converter.convertToConsult(consultDTO);
        return consultRepository.save(consult);
    }

    @Transactional
    public Lawyer getLawyerById(Long lawyerId) throws Exception {
        return lawyerRepository.findById(lawyerId).orElseThrow(() -> new Exception("존재하지 않는 변호사입니다"));
    }

    @Transactional
    public Client getClientById(Long clientId) throws Exception {
        return clientRepository.findById(clientId).orElseThrow(() -> new Exception("존재하지 않는 고객입니다"));
    }
}
