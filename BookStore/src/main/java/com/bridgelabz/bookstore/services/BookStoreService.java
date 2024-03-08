package com.bridgelabz.bookstore.services;

import com.bridgelabz.bookstore.dto.UserEntityDTO;
import com.bridgelabz.bookstore.entity.UserEntity;
import com.bridgelabz.bookstore.repository.IBookStoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.LocalDate.parse;

@Service
public class BookStoreService implements IBookStoreService {
    @Autowired
    private IBookStoreRepository repo;
    public List<UserEntityDTO> getAllUserDetails(){
        return repo.findAll()
                .stream()
                .map(userEntity -> new UserEntityDTO(
                        userEntity.getUserId(),
                        userEntity.getUserFirstName(),
                        userEntity.getUserLastName(),
                        userEntity.getUserDob()
                )).collect(Collectors.toList());
    }
    public List<UserEntityDTO> getUserById(@PathVariable int id){
       return repo.findById(id).stream()
               .map(userEntity -> new UserEntityDTO(
                       userEntity.getUserId(),
                       userEntity.getUserFirstName(),
                       userEntity.getUserLastName(),
                       userEntity.getUserDob()
               )).collect(Collectors.toList());
       // return repo.fin>dById(id).get();
    }

    public void postUser(@RequestBody UserEntity userEntity){
        repo.save(userEntity);
    }

    public UserEntity putUserDetails(@PathVariable int id){
        UserEntity userEntity = repo.findById(id).get();
        userEntity.setUserFirstName("Nikhil");
        userEntity.setUserLastName("Jana");
        userEntity.setUserDob(parse("2024-03-02"));
        repo.save(userEntity);
        return userEntity;
    }
    public void deleteUser(@PathVariable int id){
        UserEntity userEntity = repo.findById(id).get();
        repo.delete(userEntity);
    }

}
