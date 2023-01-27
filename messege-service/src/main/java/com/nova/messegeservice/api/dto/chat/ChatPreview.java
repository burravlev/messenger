package com.nova.messegeservice.api.dto.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nova.messegeservice.model.Chat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatPreview {
    private Long id;
    private String receiver;
    @JsonProperty("last_message")
    private String lastMessage;

    public ChatPreview(String sender, Chat chat, String lastMessage) {
        this.id = chat.getId();
        this.receiver = sender.equals(chat.getSender()) ?
                chat.getReceiver() :
                chat.getSender();
        this.lastMessage = lastMessage;
    }
}
