package com.electronic.store.services;

import com.electronic.store.dtos.UserDto;
import com.electronic.store.entities.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updatedUser(UserDto userDto, String userId);

    void deleteUser(String userId);


    UserDto getUserById(String userId);

    UserDto getUserByEmail(String email);

    List<UserDto> searchUser(String keyword);

    List<UserDto>   getAllUser();


}
