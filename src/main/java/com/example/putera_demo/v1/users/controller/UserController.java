package com.example.putera_demo.v1.users.controller;

import com.example.putera_demo.common.model.Pagination;
import com.example.putera_demo.v1.users.model.dto.UserDto;
import com.example.putera_demo.v1.users.model.entity.Role;
import com.example.putera_demo.v1.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo-putera-api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Pagination<UserDto>> getAllUsers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {

        Pagination<UserDto> paginatedUsers = userService.getAllUsers(page, limit);

        return ResponseEntity.ok(paginatedUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}
