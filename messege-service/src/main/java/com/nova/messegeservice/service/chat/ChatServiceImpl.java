package com.nova.messegeservice.service.chat;

import com.nova.messegeservice.api.dto.chat.ChatDto;
import com.nova.messegeservice.api.dto.chat.ChatPreview;
import com.nova.messegeservice.api.dto.chat.ChatRequest;
import com.nova.messegeservice.model.Chat;
import com.nova.messegeservice.model.Message;
import com.nova.messegeservice.repository.ChatRepository;
import com.nova.messegeservice.repository.MessageRepository;
import com.nova.messegeservice.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;
    private final MessageService messageService;

    @Override
    public List<ChatDto> getAll(String user, Integer size, Integer page) {
        return chatRepository.findAll(user, Pageable.ofSize(size).withPage(page))
                .stream().map(chat -> new ChatDto(
                        user,
                        chat,
                        messageService.findAll(chat.getId(), 20, 0))
                        ).collect(Collectors.toList());
    }

    @Override
    public ChatDto create(String sender, ChatRequest request) {
        Chat chat = new Chat();
        chat.setSender(sender);
        chat.setReceiver(request.getReceiver());
        chatRepository.save(chat);
        return new ChatDto(sender, chat);
    }
}
