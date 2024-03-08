package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.dto.UserEntityDTO;
import com.bridgelabz.bookstore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookStoreRepository extends JpaRepository<UserEntity, Integer> {

}
