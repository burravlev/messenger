package com.nova.messegeservice.service.message;

import com.nova.messegeservice.api.dto.message.MessageDto;
import com.nova.messegeservice.api.dto.message.MessageRequest;
import com.nova.messegeservice.model.Message;
import com.nova.messegeservice.repository.ChatRepository;
import com.nova.messegeservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private SimpMessagingTemplate messagingTemplate;
    private ChatRepository chatRepository;
    private MessageRepository messageRepository;

    @Override
    public MessageDto send(MessageRequest request) {
        Message message = messageRepository.save(request.toEntity());
        MessageDto dto = new MessageDto(message);
        messagingTemplate.convertAndSendToUser(message.getReceiver(), "/private", dto);
        return dto;
    }
}
