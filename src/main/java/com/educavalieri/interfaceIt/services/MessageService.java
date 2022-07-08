package com.educavalieri.interfaceIt.services;

import com.educavalieri.interfaceIt.dtos.MessageDto;
import com.educavalieri.interfaceIt.entities.Message;

import java.util.List;

public interface MessageService {

    List<MessageDto> findAll();

    MessageDto findById(Long id);

    MessageDto insert(MessageDto messageDto);


}
