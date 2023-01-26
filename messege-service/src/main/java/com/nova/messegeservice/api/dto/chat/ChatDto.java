package com.nova.messegeservice.api.dto.chat;

import com.nova.messegeservice.model.Chat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChatDto {
    private Long id;
    private String receiver;

    public ChatDto(String sender, Chat chat) {
        this.id = chat.getId();
        this.receiver = sender.equals(chat.getSender()) ?
                chat.getReceiver() :
                chat.getSender();
    }
}
