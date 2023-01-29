package com.messenger.userservice.service.user;

import com.messenger.userservice.api.dto.UserDto;
import com.messenger.userservice.api.dto.UserRequest;

public interface UserService {
    UserDto create(UserRequest request);
    UserDto get(Long id);
    UserDto delete(Long id);
}
