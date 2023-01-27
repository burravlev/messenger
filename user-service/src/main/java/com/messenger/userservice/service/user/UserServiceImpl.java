package com.messenger.userservice.service.user;

import com.messenger.userservice.api.dto.UserDto;
import com.messenger.userservice.repositry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> findByUsername(String username, Integer size, Integer page) {
        List<UserDto> dtos = userRepository.findByUsername(username, Pageable.ofSize(size).withPage(page))
                .stream().map(UserDto::new)
                .toList();
        return dtos;
    }
}
