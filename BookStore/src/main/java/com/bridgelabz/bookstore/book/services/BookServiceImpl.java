package com.bridgelabz.bookstore.book.services;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bridgelabz.bookstore.user.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl {


//    public List<UserEntity> getBook(@RequestHeader String token){
////        try {
////            String userFirstName = userJwt.decodeToken(token);
////            UserEntity userEntity = repo.findByFirstName(userFirstName);
////            System.out.println(userEntity);
////            return Collections.singletonList(userEntity);
////        } catch (JWTVerificationException ex){
////            ex.printStackTrace();
////            return Collections.emptyList();
////        }
//    }
}
