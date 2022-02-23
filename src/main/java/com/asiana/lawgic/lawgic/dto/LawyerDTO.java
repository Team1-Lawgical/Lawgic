package com.asiana.lawgic.lawgic.dto;

import com.asiana.lawgic.lawgic.entity.Category;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@ToString
public class LawyerDTO {
    private Long lawyerId;

    private String name;

    private String address;

    private String email;

    private String phone;

    private boolean valid;

    private boolean gender;

    private Category categoryId;
}
