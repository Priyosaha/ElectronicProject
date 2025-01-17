package com.electronic.store.services.impl;

import com.electronic.store.dtos.UserDto;
import com.electronic.store.entities.User;
import com.electronic.store.repositories.UserRepository;
import com.electronic.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        String randomId = UUID.randomUUID().toString();
        userDto.setUserId(randomId);
        User user = UserDtoToEntity(userDto);
        User savedUser = userRepository.save(user);
        return EntitytoUserDto(savedUser);
    }

    @Override
    public UserDto updatedUser(UserDto userDto, String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found !!"));
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setImageName(userDto.getImageName());

        User updatedUser = userRepository.save(user);

        return EntitytoUserDto(updatedUser);

    }

    @Override
    public void deleteUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found !!"));
        userRepository.delete(user);

    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUser = userRepository.findAll();
        List<UserDto> allUserDto = new ArrayList<>();
        for(User user : allUser) {
            UserDto userDto = EntitytoUserDto(user);
            allUserDto.add(userDto);
        }
        return allUserDto;
    }

    @Override
    public UserDto getUserById(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
        return EntitytoUserDto(user);

    }

    @Override
    public UserDto getUserByEmail(String email) {

        return null;
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        return List.of();
    }


    private UserDto EntitytoUserDto(User savedUser) {

        return UserDto.builder()
                .userId(savedUser.getUserId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .gender(savedUser.getGender())
                .about(savedUser.getAbout())
                .imageName(savedUser.getImageName()).build();

    }

    private User UserDtoToEntity(UserDto userDto) {
        return User.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .gender(userDto.getGender())
                .about(userDto.getAbout())
                .imageName(userDto.getImageName()).build();
    }
}
