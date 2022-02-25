package com.asiana.lawgic.lawgic.converter;

import com.asiana.lawgic.lawgic.dto.ConsultDTO;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.entity.Consult;
import com.asiana.lawgic.lawgic.entity.Lawyer;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import com.asiana.lawgic.lawgic.repository.LawyerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.asiana.lawgic.lawgic.entity.CarType.convertStringToInteger;
import static com.asiana.lawgic.lawgic.entity.CarType.convertToCarType;

@Component
public class ConsultConverter {
    private final LawyerRepository lawyerRepository;
    private final ClientRepository clientRepository;

    public ConsultConverter(LawyerRepository lawyerRepository, ClientRepository clientRepository) {
        this.lawyerRepository = lawyerRepository;
        this.clientRepository = clientRepository;
    }

    public Consult convertToConsult(ConsultDTO consultDTO) {
        Consult consult = Consult.builder()
                .appointmentDate(consultDTO.getAppointmentDate())
                .summary(consultDTO.getSummary())
                .judgement(consultDTO.getJudgement())
                .comments(consultDTO.getComments())
                .opponentName(consultDTO.getOpponentName())
                .opponentAddress(consultDTO.getOpponentAddress())
                .opponentBirthday(consultDTO.getOpponentBirthday())
                .opponentPhone(consultDTO.getOpponentPhone())
                .opponentCarType(convertToCarType(convertStringToInteger(consultDTO.getOpponentCarType())))
                .build();

        Optional<Lawyer> result = lawyerRepository.findById(consultDTO.getLawyerId());
        Lawyer lawyer = result.get();
        consult.setLawyer(lawyer);

        Optional<Client> rs = clientRepository.findById(consultDTO.getClientId());
        Client client = rs.get();
        consult.setClient(client);
        return consult;
    }
}
