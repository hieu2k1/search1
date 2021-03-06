package com.example.sem4.service;

import com.example.sem4.entity.UserEntity;
import com.example.sem4.model.UserDto;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetails {
    UserDetails loadUserByUsername(String username);
    UserEntity signUpUser(UserDto userDto);
    List<UserEntity> getAllUser(Pageable pageable);
    int getTotalPage(Pageable pageable);
    UserEntity getUserById(int id);
    //    UserEntity createUser(UserEntity p);
    void deleteUser(int id);
    UserEntity updateUser(UserEntity p);
    List<UserEntity> getUserByFullName(String name);

}
