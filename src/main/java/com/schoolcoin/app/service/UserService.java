package com.schoolcoin.app.service;

import com.schoolcoin.app.domain.users.User;
import com.schoolcoin.app.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDto userDto);
    List<UserDto> getAll();
    User findByName (String name);
    void updateProfile(UserDto dto);
}
