package com.nova.messegeservice.service.message;

import com.nova.messegeservice.api.dto.message.MessageDto;
import com.nova.messegeservice.api.dto.message.MessageRequest;

import java.util.List;

public interface MessageService {
    MessageDto send(MessageRequest request);

    List<MessageDto> findAll(Long id, Integer size, Integer page);
}
