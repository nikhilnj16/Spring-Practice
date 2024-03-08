package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.UserEntityDTO;
import com.bridgelabz.bookstore.entity.UserEntity;
import com.bridgelabz.bookstore.services.IBookStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IBookStoreService service;

    @GetMapping("/read")
    public List<UserEntityDTO> findAllUserDetails(){
        return service.getAllUserDetails();
    }

    @GetMapping("/read/{id}")
    public List<UserEntityDTO> findUserById(@PathVariable int id){

        return service.getUserById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody UserEntity userEntity){
        service.postUser(userEntity);
    }
    @PutMapping("/update/{id}")
    public UserEntity updateUserDetails(@PathVariable int id){
        return service.putUserDetails(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }
}
