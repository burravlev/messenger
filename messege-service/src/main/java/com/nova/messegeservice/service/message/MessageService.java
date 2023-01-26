package com.nova.messegeservice.service.message;

import com.nova.messegeservice.api.dto.message.MessageDto;
import com.nova.messegeservice.api.dto.message.MessageRequest;

public interface MessageService {
    MessageDto send(MessageRequest request);
}
