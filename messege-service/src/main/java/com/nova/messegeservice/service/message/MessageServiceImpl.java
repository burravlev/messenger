package com.nova.messegeservice.service.message;

import com.nova.messegeservice.api.dto.message.MessageDto;
import com.nova.messegeservice.api.dto.message.MessageRequest;
import com.nova.messegeservice.model.Message;
import com.nova.messegeservice.repository.ChatRepository;
import com.nova.messegeservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    @Override
    public MessageDto send(MessageRequest request) {
        Message message = messageRepository.save(request.toEntity());
        chatRepository.updateDate(LocalDateTime.now(), message.getChatId());
        MessageDto dto = new MessageDto(message);
        messagingTemplate.convertAndSendToUser(message.getReceiver(), "/private", dto);
        return dto;
    }
}
