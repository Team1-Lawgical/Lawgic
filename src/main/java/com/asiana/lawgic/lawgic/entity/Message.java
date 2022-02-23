package com.asiana.lawgic.lawgic.entity;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Builder
@Embeddable
public class Message extends BaseEntity{

    private String content;

    private String sender;

    private String receiver;

    private MessageType type;
}
