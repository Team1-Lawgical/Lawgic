package com.asiana.lawgic.lawgic.dto;

import com.asiana.lawgic.lawgic.entity.CarType;
import lombok.Getter;

import java.sql.Date;

@Getter

public class ConsultDTO {

    private Long consultId;
    private Date appointmentDate;
    private String summary;
    private String judgement;
    private String comments;
    private String opponentName;
    private String opponentAddress;
    private Date opponentBirthday;
    private String opponentPhone;
    private CarType opponentCarType;
    private Long clientId;
    private Long lawyerId;
}
