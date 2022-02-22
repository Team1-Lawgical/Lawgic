package com.asiana.lawgic.lawgic.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Consult {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
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

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinColumn(name="lawyer_id")
    private Lawyer lawyer;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinColumn(name="client_id")
    private Client client;
}
