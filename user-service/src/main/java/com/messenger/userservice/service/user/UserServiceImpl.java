package com.messenger.userservice.service.user;

import com.messenger.userservice.api.dto.UserDto;
import com.messenger.userservice.api.dto.UserRequest;
import com.messenger.userservice.model.User;
import com.messenger.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserRequest request) {
        User user = userRepository.save(request.toEntity());
        return new UserDto(user);
    }

    @Override
    public UserDto get(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No such user"));
        return new UserDto(user);
    }

    @Override
    public UserDto delete(Long id) {
        User user = get(id).toEntity();
        userRepository.delete(user);
        return new UserDto(user);
    }
}
