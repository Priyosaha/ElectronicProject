package com.electronic.store.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

        private String userId;

        @Size(min = 4,max = 16 , message = "Invalid name")
        private String name;

        @NotBlank
        @Email(message = "Invalid email")
        private String email;

        @Size(min = 5, max = 15)
        private String password;

        @Size(min = 4, max = 6)
        private String gender;

        @NotBlank(message = "Invalid about")
        private String about;
        private String imageName;
    }
