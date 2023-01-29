package com.messenger.userservice.api.controller;

import com.messenger.userservice.api.dto.UserDto;
import com.messenger.userservice.api.dto.UserRequest;
import com.messenger.userservice.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/{user_id}")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDto> get(@PathVariable("user_id") Long id) {
        UserDto dto = userService.get(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(UserRequest request) {
        UserDto dto = userService.create(request);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<UserDto> delete(@PathVariable("user_id") Long id) {
        UserDto dto = userService.delete(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
