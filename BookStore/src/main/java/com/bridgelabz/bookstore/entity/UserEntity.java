package com.bridgelabz.bookstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column
    private String userFirstName;
    @Column
    private String userLastName;
    @Column
    private LocalDate userDob;
    @Column
    private LocalDate userRegisteredDate;
    @Column
    private LocalDate userUpdatedDate;
    @Column
    private String userPassword;
    @Column
    private String userEmailId;
    private Boolean UserVerify;
    private int userOtp;



}
