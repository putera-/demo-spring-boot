package com.example.putera_demo.v1.users.model.dto;

import com.example.putera_demo.v1.users.model.entity.Role;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String email;
    private String firstname;
    private String lastname;
    private Boolean active;
    private Boolean verified;
    private String avatar;
    private Role role;
}
