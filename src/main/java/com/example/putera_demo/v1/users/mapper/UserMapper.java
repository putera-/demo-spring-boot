package com.example.putera_demo.v1.users.mapper;

import com.example.putera_demo.v1.users.model.dto.UserDto;
import com.example.putera_demo.v1.users.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public  interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
