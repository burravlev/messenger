package com.nova.messegeservice.api.dto.message;

import com.nova.messegeservice.model.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MessageDto {
    private Long id;
    private String content;
    private String sender;
    private String receiver;
    private String chatId;
    private LocalDateTime sent;

    public MessageDto(Message message) {
        this.id = message.getId();
        this.content = message.getContent();
        this.sender = message.getSender();
        this.receiver = message.getReceiver();
        this.chatId = message.getChatId();
        this.sent = message.getSent();
    }
}
