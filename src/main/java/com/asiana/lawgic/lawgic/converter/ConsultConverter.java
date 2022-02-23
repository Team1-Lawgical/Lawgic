package com.asiana.lawgic.lawgic.converter;

import com.asiana.lawgic.lawgic.dto.ConsultDTO;
import com.asiana.lawgic.lawgic.entity.Consult;

public class ConsultConverter {

    public Consult convertToConsult(ConsultDTO consultDTO){
        return Consult.builder()
                .appointmentDate(consultDTO.getAppointmentDate())
                .summary(consultDTO.getSummary())
                .judgement(consultDTO.getJudgement())
                .comments(consultDTO.getComments())
                .opponentName(consultDTO.getOpponentName())
                .opponentAddress(consultDTO.getOpponentAddress())
                .opponentBirthday(consultDTO.getOpponentBirthday())
                .opponentPhone(consultDTO.getOpponentPhone())
                .opponentCarType(consultDTO.getOpponentCarType())
                .build();
    }
}
