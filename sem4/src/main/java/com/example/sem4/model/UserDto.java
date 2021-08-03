package com.example.sem4.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String fullName;
    private String password;
    private String email;
    private String username;


}
