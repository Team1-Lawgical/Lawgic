package com.asiana.lawgic.lawgic.dto;

import com.asiana.lawgic.lawgic.entity.MessageType;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@ToString
public class MessageDTO {
    private String content;

    private String sender;

    private String receiver;

    private String regdate;

    private MessageType type;


}
