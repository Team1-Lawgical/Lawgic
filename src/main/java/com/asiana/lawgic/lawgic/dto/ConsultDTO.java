package com.asiana.lawgic.lawgic.dto;

import com.asiana.lawgic.lawgic.entity.CarType;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
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
    private String  opponentCarType;
    private Long clientId;
    private Long lawyerId;
}
