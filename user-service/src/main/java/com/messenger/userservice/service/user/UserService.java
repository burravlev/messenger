package com.messenger.userservice.service.user;

import com.messenger.userservice.api.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findByUsername(String username, Integer size, Integer page);
}
