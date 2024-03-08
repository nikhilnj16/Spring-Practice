package com.bridgelabz.bookstore.dto;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntityDTO{

        long userId;
        String userFirstName;
        String userLastName;
        LocalDate userDob;
}


