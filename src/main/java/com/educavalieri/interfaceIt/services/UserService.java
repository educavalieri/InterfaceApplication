package com.educavalieri.interfaceIt.services;

import com.educavalieri.interfaceIt.dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto dto);

    List<UserDto> findAll();

    UserDto findById(Long id);

}
