package com.bridgelabz.bookstore.user.services;


import com.bridgelabz.bookstore.user.utility.EmailSender;
import com.bridgelabz.bookstore.user.utility.UserJwt;
import com.bridgelabz.bookstore.user.dto.UserLoginDTO;
import com.bridgelabz.bookstore.user.entity.UserEntity;
import com.bridgelabz.bookstore.user.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserRegImpl implements IUserReg {
    @Autowired
    private IUserRepository repo;

    @Autowired
    UserJwt userJwt;

    @Autowired
    EmailSender emailSender;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String userRegistration(UserEntity userEntity){
        String encodePassword = passwordEncoder.encode(userEntity.getUserPassword());
        userEntity.setUserPassword(encodePassword);
        userEntity.setUserVerified(false);
        repo.save(userEntity);
        System.out.println(userEntity);
        String body = "Thanks for registering in Book store app."+ " click here to verify you account   " + "http://localhost:8085/login" ;
        String subject = "registered successfully and get your account verified";
        System.out.println(userEntity.getUserEmailId());
        emailSender.sendEmail(userEntity.getUserEmailId(), subject ,body);
        return  "User register successfully";
    }

    public String userLogin(UserLoginDTO userLoginDto){
//        String encodePassword = passwordEncoder.encode(userLoginDto.getUserPassword());
//        System.out.println(encodePassword);

        UserEntity userEntity = repo.findByEmailId(userLoginDto.getUserEmailId());

        if(userEntity != null && passwordEncoder.matches(userLoginDto.getUserPassword(), userEntity.getUserPassword())) {
            String token = userJwt.createToken(userEntity.getUserFirstName());
            if(userEntity.getUserVerified().equals(false)) {
                String body = "Successfully registered";
                String subject = "account verified";
                emailSender.sendEmail(userLoginDto.getUserEmailId(), subject, body);
                userEntity.setUserVerified(true);
                repo.save(userEntity);
            }
            return "Login successful. JWT Token: " + token;

        } else {
            return "Invalid credentials. login failed";
        }
    }


    @Override
    public UserEntity getUser(String token) {
        String userFirstName = userJwt.decodeToken(token);
        System.out.println(repo.findByFirstName(userFirstName));
        return repo.findByFirstName(userFirstName);
    }

    //    @Autowired
//    private IBookStoreRepository repo;
//    public List<UserLoginDto> getAllUserDetails(){
//        return repo.findAll()
//                .stream()
//                .map(userEntity -> new UserLoginDto(
//                        userEntity.getUserId(),
//                        userEntity.getUserFirstName(),
//                        userEntity.getUserLastName()
//
//                )).collect(Collectors.toList());
//    }
//    public List<UserLoginDto> getUserById(@PathVariable int id){
//       return repo.findById(id).stream()
//               .map(userEntity -> new UserLoginDto(
//                       userEntity.getUserId(),
//                       userEntity.getUserFirstName(),
//                       userEntity.getUserLastName()
//
//               )).collect(Collectors.toList());
//       // return repo.fin>dById(id).get();
//    }
//
//    public void postUser(@RequestBody UserEntity userEntity){
//        repo.save(userEntity);
//    }
//
//    public UserEntity putUserDetails(@PathVariable int id){
//        UserEntity userEntity = repo.findById(id).get();
//        userEntity.setUserFirstName("Nikhil");
//        userEntity.setUserLastName("Jana");
//        repo.save(userEntity);
//        return userEntity;
//    }
//    public void deleteUser(@PathVariable int id){
//        UserEntity userEntity = repo.findById(id).get();
//        repo.delete(userEntity);
//    }

}
