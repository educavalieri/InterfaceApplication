package com.educavalieri.interfaceIt.services.implement;


import com.educavalieri.interfaceIt.dtos.MessageDto;
import com.educavalieri.interfaceIt.entities.Message;
import com.educavalieri.interfaceIt.entities.User;
import com.educavalieri.interfaceIt.mapper.MessageMapper;
import com.educavalieri.interfaceIt.repositories.MessageRepository;
import com.educavalieri.interfaceIt.repositories.UserRepository;
import com.educavalieri.interfaceIt.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public List<MessageDto> findAll() {
        List<Message> messages = messageRepository.findAll();
        List<MessageDto> messageDtos = messages.stream().map( x -> MessageDto
                .builder()
                .code(x.getCode())
                .text(x.getText())
                .userId(x.getUser().getId())
                .build())
                .collect(Collectors.toList());
        return messageDtos;
    }

    @Override
    @Transactional
    public MessageDto findById(Long id) {

        Message message = messageRepository.findById(id).get();
        return MessageMapper.toDto(message);

    }

    @Override
    @Transactional
    public MessageDto insert(MessageDto messageDto) {

        User user = userRepository.getById(messageDto.getUserId());
        Message message = MessageMapper.toEntity(messageDto, user);
        messageRepository.save(message);

        return MessageMapper.toDto(message);
    }
}
