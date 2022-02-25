package com.asiana.lawgic.lawgic.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Builder
@Embeddable
public class Message{

    private String content;

    private String sender;

    private String receiver;

    private MessageType type;

    private LocalDateTime regDate;


}
