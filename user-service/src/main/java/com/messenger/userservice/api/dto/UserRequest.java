package com.messenger.userservice.api.dto;

import com.messenger.userservice.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String username;

    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
