package com.asiana.lawgic.lawgic.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Chat {
    @Column(name="chat_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long chatId;

    @CollectionTable(name = "message", joinColumns = @JoinColumn(name = "chat_id"))
    @ElementCollection(fetch= FetchType.EAGER)
    List<Message> messages=new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE )
    @JoinColumn(name="lawyer_id")
    private Lawyer lawyer;


    @JoinColumn(name="client_id")
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Client client;

    @JoinColumn(name="consult_id")
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    private Consult consult;

    public void setMessages(List<Message> messages){
        this.messages=messages;
    }
}
