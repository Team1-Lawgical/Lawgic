package com.asiana.lawgic.lawgic.dto;

import com.asiana.lawgic.lawgic.entity.CarType;
import lombok.*;

import java.sql.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@ToString
public class ClientDTO {
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
