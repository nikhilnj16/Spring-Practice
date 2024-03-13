package com.bridgelabz.springjwt.user.services;


import com.bridgelabz.springjwt.user.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IUserService {
//    List<UserEntity> getAllUserDetails();
//    List<UserEntity> getUserById(@PathVariable int id);
    void add(UserEntity userEntity);

}
