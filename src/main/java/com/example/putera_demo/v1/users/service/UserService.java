package com.example.putera_demo.v1.users.service;

import com.example.putera_demo.exception.ResourceNotFoundException;
import com.example.putera_demo.v1.users.mapper.UserMapper;
import com.example.putera_demo.v1.users.model.dto.UserDto;
import com.example.putera_demo.v1.users.model.entity.User;
import com.example.putera_demo.v1.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    }

    public UserDto getUserById(String id) {
        User user =  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.userToUserDto(user);
    }
}
