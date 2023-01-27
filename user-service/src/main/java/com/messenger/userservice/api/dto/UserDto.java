package com.messenger.userservice.api.dto;

import com.messenger.userservice.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String name;
    private String surname;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.surname = user.getSurname();
    }

    public User toEntity() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }
}
