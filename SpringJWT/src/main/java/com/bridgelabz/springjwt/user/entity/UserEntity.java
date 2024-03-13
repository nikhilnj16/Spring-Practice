package com.bridgelabz.springjwt.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    private int userId;
    @NotNull
    @Size(min=2, message = "Must be not null")
    private String userName;
    @NotBlank(message = "Must be not blank")
    private String userPassword;
    @Email(message = "Email should be valid")
//    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$\n")
    private String userEmail;
    @ValidateUserType
    private String userRole;




}

