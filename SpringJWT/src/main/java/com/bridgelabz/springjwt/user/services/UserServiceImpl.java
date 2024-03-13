package com.bridgelabz.springjwt.user.services;

import com.bridgelabz.springjwt.user.entity.UserEntity;
import com.bridgelabz.springjwt.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository repo;
//    public List<UserEntity> getAllUserDetails(){
//        return repo.findAll()
//                .stream()
//                .map(userEntity -> new User(
//                        userEntity.getUserName(),
//                        userEntity.getUserPassword()
//                )).collect(Collectors.toList());
//    }
//    public List<UserDTO> getUserById(@PathVariable int id){
//        return repo.findById(id).stream()
//                .map(userEntity -> new UserDTO(
//                        userEntity.getUserName(),
//                        userEntity.getUserPassword()
//
//                )).collect(Collectors.toList());
//        // return repo.fin>dById(id).get();
//    }

    public void add(UserEntity userEntity){
        repo.save(userEntity);
    }
}
