package com.educavalieri.interfaceIt.mapper;

import com.educavalieri.interfaceIt.dtos.MessageDto;
import com.educavalieri.interfaceIt.entities.Message;
import com.educavalieri.interfaceIt.entities.User;

public class MessageMapper {


    public static Message toEntity(MessageDto dto, User user){

        return Message
                .builder()
                .user(user)
                .id(dto.getUserId())
                .text(dto.getText())
                .code(dto.getCode())
                .build();

    }

    public static MessageDto toDto(Message message){

        return MessageDto
                .builder()
                .code(message.getCode())
                .userId(message.getId())
                .text(message.getText())
                .build();
    }


}
