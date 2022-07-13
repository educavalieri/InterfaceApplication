package com.educavalieri.interfaceIt.services.implement;

import com.educavalieri.interfaceIt.dtos.UserDto;
import com.educavalieri.interfaceIt.entities.User;
import com.educavalieri.interfaceIt.mapper.UserMapper;
import com.educavalieri.interfaceIt.repositories.UserRepository;
import com.educavalieri.interfaceIt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDto save(UserDto dto) {

        User user = UserMapper.toEntity(dto);
        userRepository.save(user);
        return UserMapper.toDto(user);

    }

    @Override
    @Transactional
    public List<UserDto> findAll() {

        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users
                .stream()
                .map(x -> UserDto
                        .builder()
                        .email(x.getEmail())
                        .firstName(x.getFirstName())
                        .lastName(x.getLastName())
                        .build())
                .collect(Collectors.toList());

        return userDtos;
    }

    @Override
    @Transactional
    public UserDto findById(Long id) {
        User user = userRepository.getById(id);
        return UserMapper.toDto(user);
    }
}
