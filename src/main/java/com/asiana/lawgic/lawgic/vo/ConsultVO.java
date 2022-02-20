package com.asiana.lawgic.lawgic.vo;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultVO {
    private Long consultId;
    private String appointmentDate;
    private Long lawyerId;
    private String opponentName;
    private String opponentAddress;
    private String opponentBirthday;
    private String opponentPhone;
    private String opponentCarType;
    private String summary;
    private String judgement;
    private String comments;
    private Long clientId;
}
