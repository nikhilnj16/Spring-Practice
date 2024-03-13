package com.bridgelabz.bookstore.book.controller;

import com.bridgelabz.bookstore.book.services.BookServiceImpl;
import com.bridgelabz.bookstore.user.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookService;

//    @GetMapping("/getBook")
//    public List<UserEntity> getBook(@RequestHeader String token){
//        return bookService.getBook(token);
//    }

}
