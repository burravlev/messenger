package com.nova.messegeservice.api.controller;

import com.nova.messegeservice.api.dto.message.MessageDto;
import com.nova.messegeservice.api.dto.message.MessageRequest;
import com.nova.messegeservice.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessagingController {
    private final MessageService messageService;

    @MessageMapping("/message")
    public MessageDto processMessage(@Payload MessageRequest request) {
        return messageService.send(request);
    }
}