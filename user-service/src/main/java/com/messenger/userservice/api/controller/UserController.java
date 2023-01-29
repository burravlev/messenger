package com.messenger.userservice.api.controller;

import com.messenger.userservice.api.dto.UserDto;
import com.messenger.userservice.api.dto.UserRequest;
import com.messenger.userservice.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @GetMapping("/{user}")
    public ResponseEntity<List<UserDto>> getByUsername(
            @PathVariable String user,
            @RequestParam(name = "size", required = false, defaultValue = "4") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        List<UserDto> dtos = userService.findByUsername(user, size, page);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserRequest request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
