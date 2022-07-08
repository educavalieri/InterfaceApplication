package com.educavalieri.interfaceIt.controllers;

import com.educavalieri.interfaceIt.dtos.MessageDto;
import com.educavalieri.interfaceIt.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")

public class MessageController {


    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<MessageDto>> findAll(){
        List<MessageDto> messageDtos = messageService.findAll();
        return ResponseEntity.ok().body(messageDtos);
    }

    @GetMapping(value = "/findById{id}")
    public ResponseEntity<MessageDto> findById(@PathVariable("id") Long id){
        MessageDto messageDto = messageService.findById(id);
        return ResponseEntity.ok().body(messageDto);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<MessageDto> save(@RequestBody MessageDto dto){
        MessageDto messageDto = messageService.insert(dto);
        return ResponseEntity.ok().body(messageDto);
    }

}
