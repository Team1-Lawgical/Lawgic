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
    public void insertConsult(ConsultDTO consultDTO) throws Exception {
//        getLawyerById(consultDTO.getClientId());
//        getClientById(consultDTO.getLawyerId());
        if (consultDTO.getLawyerId() == null || consultDTO.getClientId() == null) {
            System.out.println("로이어 아이디랑 고객 아이디 중에 하나가 null");
        }
        Consult consult = converter.convertToConsult(consultDTO);
        consultRepository.save(consult);
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
