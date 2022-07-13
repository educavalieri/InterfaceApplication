package com.educavalieri.interfaceIt.controllers;

import com.educavalieri.interfaceIt.dtos.UserDto;
import com.educavalieri.interfaceIt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "insert/")
    public ResponseEntity<UserDto> insert(@RequestBody UserDto dto){

        dto = userService.save(dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<UserDto>> findAll(){

        List<UserDto> userDtos = userService.findAll();
        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/findById{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){

        UserDto dto = userService.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
