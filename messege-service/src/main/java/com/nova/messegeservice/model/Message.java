package com.nova.messegeservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String sender;
    private String receiver;
    @Column(name="chat_id")
    private Long chatId;
    private LocalDateTime sent;

    public Message() {
        this.sent = LocalDateTime.now();
    }

    public Message(
            String content,
            String sender,
            String receiver,
            Long chatId
    ) {
        this();
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.chatId = chatId;
    }

    public Message(String content) {
        this.content = content;
    }
}
