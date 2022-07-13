package com.educavalieri.interfaceIt.mapper;

import com.educavalieri.interfaceIt.dtos.UserDto;
import com.educavalieri.interfaceIt.entities.User;

public class UserMapper {

    public static User toEntity(UserDto dto){
        return User
                .builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
    }

    public static UserDto toDto(User user){
        return UserDto
                .builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }



}
