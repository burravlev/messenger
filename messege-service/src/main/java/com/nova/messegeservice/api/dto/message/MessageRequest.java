package com.nova.messegeservice.api.dto.message;

import com.nova.messegeservice.model.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MessageRequest {
    private String content;
    private String sender;
    private String receiver;
    private String chatId;

    public Message toEntity() {
        return new Message(

        );
    }
}
