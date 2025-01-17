package com.electronic.store.controllers;


import com.electronic.store.dtos.UserDto;
import com.electronic.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        UserDto user = userService.createUser(userDto);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
