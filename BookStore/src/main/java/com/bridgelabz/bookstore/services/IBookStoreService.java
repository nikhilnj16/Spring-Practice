package com.bridgelabz.bookstore.services;

import com.bridgelabz.bookstore.dto.UserEntityDTO;
import com.bridgelabz.bookstore.entity.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBookStoreService {
    List<UserEntityDTO> getAllUserDetails();
    List<UserEntityDTO> getUserById(@PathVariable int id);

    void postUser(@RequestBody UserEntity userEntity);
    UserEntity putUserDetails(@PathVariable int id);
    void deleteUser(@PathVariable int id);
}
