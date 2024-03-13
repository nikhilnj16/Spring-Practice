package com.bridgelabz.bookstore.user.services;


import com.bridgelabz.bookstore.user.dto.UserLoginDTO;
import com.bridgelabz.bookstore.user.entity.UserEntity;

import java.util.List;

public interface IUserReg {

    String userRegistration(UserEntity userEntity);
    String userLogin(UserLoginDTO userLoginDto);

    UserEntity getUser(String token);

//    List<UserLoginDto> getAllUserDetails();
//    List<UserLoginDto> getUserById(@PathVariable int id);
//
//    void postUser(@RequestBody UserEntity userEntity);
//    UserEntity putUserDetails(@PathVariable int id);
//    void deleteUser(@PathVariable int id);
}
