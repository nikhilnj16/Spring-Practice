package com.bridgelabz.bookstore.user.controller;


import com.bridgelabz.bookstore.user.utility.EmailSender;
import com.bridgelabz.bookstore.user.utility.UserJwt;
import com.bridgelabz.bookstore.user.dto.UserLoginDTO;
import com.bridgelabz.bookstore.user.entity.UserEntity;
import com.bridgelabz.bookstore.user.services.IUserReg;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserReg service;

    @Autowired
    UserJwt userJwt;

    @Autowired
    EmailSender emailSender;
    @PostMapping("/reg")
    @ResponseStatus(HttpStatus.CREATED)
    public String userRegistration(@RequestBody UserEntity userEntity){
        return service.userRegistration(userEntity);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserLoginDTO userLoginDto){
        return service.userLogin(userLoginDto);
    }

    @GetMapping("/getUser")
    public UserEntity getUser(@RequestHeader String token){
        return service.getUser(token);
    }

//    @GetMapping("/read")
//    public List<UserLoginDto> findAllUserDetails(){
//        return service.getAllUserDetails();
//    }
//
//    @GetMapping("/read/{id}")
//    public List<UserLoginDto> findUserById(@PathVariable int id){
//
//        return service.getUserById(id);
//    }
//
//    @PostMapping("/add")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public void createUser(@RequestBody UserEntity userEntity){
//        service.postUser(userEntity);
//    }
//    @PutMapping("/update/{id}")
//    public UserEntity updateUserDetails(@PathVariable int id){
//        return service.putUserDetails(id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable int id){
//        service.deleteUser(id);
//    }
}
