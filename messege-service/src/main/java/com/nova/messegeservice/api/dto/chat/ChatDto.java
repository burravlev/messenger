package com.nova.messegeservice.api.dto.chat;

import com.nova.messegeservice.api.dto.message.MessageDto;
import com.nova.messegeservice.model.Chat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ChatDto {
    private Long id;
    private String receiver;
    private List<MessageDto> messages;

    public ChatDto(String sender, Chat chat) {
        this.id = chat.getId();
        this.receiver = sender.equals(chat.getSender()) ?
                chat.getReceiver() :
                chat.getSender();
    }

    public ChatDto(String sender, Chat chat, List<MessageDto> messages) {
        this(sender, chat);
        this.messages = messages;
    }
}
