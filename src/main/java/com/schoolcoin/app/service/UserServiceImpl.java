package com.schoolcoin.app.service;

import com.schoolcoin.app.dao.UserRepository;
import com.schoolcoin.app.domain.users.Role;
import com.schoolcoin.app.domain.users.User;
import com.schoolcoin.app.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDto> getAll(){
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean save (UserDto userDto){
        if(!Objects.equals(userDto.getPassword(), userDto.getMatchingPassword())){
            throw new RuntimeException("Пароли не равны");
        }

        User user = User.builder()
                .name(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(Role.PARENT)
                .build();
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByName(username);
        if(user == null){
            throw new UsernameNotFoundException("Пользователь не найден: " + username);
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                roles);
    }

    @Override
    public User findByName(String name){
        return userRepository.findFirstByName(name);
    }

    //апдейт профиля, если в профиле что-то поменялось
    @Override
    @Transactional
    public void updateProfile(UserDto dto){
        User savedUser = userRepository.findFirstByName(dto.getUsername());
        if(savedUser == null){
            throw new RuntimeException("Пользователь не найден " + dto.getUsername());
        }

        boolean changed = false;
        if(dto.getPassword() != null && !dto.getPassword().isEmpty()){
            savedUser.setPassword(passwordEncoder.encode(dto.getPassword()));
            changed = true;
        }
        if(changed){
            userRepository.save(savedUser);
        }
    }

    private UserDto toDto(User user){
        return UserDto.builder()
                .username(user.getName())
                .build();
    }
}
