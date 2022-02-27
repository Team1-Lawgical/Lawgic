package com.asiana.lawgic.lawgic.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@ToString
@Entity
public class Client {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long clientId;

    private String password;

    private String name;

    private Date birthday;

    private String email;

    private String address;

    private String phone;

    private CarType carType;

    private int gender;


}
