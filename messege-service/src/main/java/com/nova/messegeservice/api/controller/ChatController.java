package com.nova.messegeservice.api.controller;

import com.nova.messegeservice.api.dto.chat.ChatDto;
import com.nova.messegeservice.api.dto.chat.ChatRequest;
import com.nova.messegeservice.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/{user}/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<List<ChatDto>> getUserChats(
            @RequestParam(required = false, defaultValue = "30") Integer size,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @PathVariable String user
    ) {
        List<ChatDto> chats = chatService.getAll(user, size, page);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChatDto> create(
            @PathVariable String user,
            @RequestBody ChatRequest request
            ) {
        ChatDto dto = chatService.create(user, request);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}