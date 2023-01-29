package com.nova.messegeservice.service.chat;

import com.nova.messegeservice.api.dto.chat.ChatDto;
import com.nova.messegeservice.api.dto.chat.ChatPreview;
import com.nova.messegeservice.api.dto.chat.ChatRequest;

import java.util.List;

public interface ChatService {
    List<ChatDto> getAll(String user, Integer size, Integer page);

    ChatDto create(String sender, ChatRequest request);
}
