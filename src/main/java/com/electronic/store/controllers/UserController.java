package com.electronic.store.controllers;


import com.electronic.store.dtos.ApiResponseMessage;
import com.electronic.store.dtos.UserDto;
import com.electronic.store.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

        UserDto user = userService.createUser(userDto);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @PathVariable("userId") String userId,
                                              @Valid @RequestBody UserDto userDto) {

        UserDto user = userService.updatedUser(userDto,userId);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        ApiResponseMessage message
                = ApiResponseMessage
                .builder()
                .message("user deleted successfully")
                .userId(userId)
                .status(HttpStatus.OK).success(true).build();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> list = userService.getAllUser();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") String userId) {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
