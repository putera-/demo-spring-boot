package com.example.putera_demo.v1.users.service;

import com.example.putera_demo.common.model.Pagination;
import com.example.putera_demo.exception.ResourceNotFoundException;
import com.example.putera_demo.v1.users.mapper.UserMapper;
import com.example.putera_demo.v1.users.model.dto.UserDto;
import com.example.putera_demo.v1.users.model.entity.Role;
import com.example.putera_demo.v1.users.model.entity.User;
import com.example.putera_demo.v1.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public Pagination<UserDto> getAllUsers(int page, int limit) {
        int totalItems = (int) userRepository.count();
        int totalPages = (int) Math.ceil((double) totalItems / limit);

        List<UserDto> users = userRepository.findAll(PageRequest.of(page - 1, limit))
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());

        Pagination<UserDto> pagination = new Pagination<>();
        pagination.setFirst(1);
        pagination.setPrev(page > 1 ? page - 1 : null);
        pagination.setNext(page < totalPages ? page + 1 : null);
        pagination.setLast(totalPages);
        pagination.setPage(page);
        pagination.setItems(totalItems);
        pagination.setData(users);

        return pagination;
    }

    public UserDto getUserById(String id) {
        User user =  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.userToUserDto(user);
    }
}
