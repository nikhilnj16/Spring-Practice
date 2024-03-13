package com.bridgelabz.springjwt.user.controller;

import com.bridgelabz.springjwt.user.entity.UserEntity;
import com.bridgelabz.springjwt.user.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;

//    @GetMapping("/read")
//    public List<UserEntity> findAllUserDetails(){
//        return service.getAllUserDetails();
//    }
//
//    @GetMapping("/read/{id}")
//    public List<UserEntity> findUserById(@PathVariable int id){
//
//        return service.getUserById(id);
//    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserEntity userEntity) {
        service.add(userEntity);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);

    }

}
