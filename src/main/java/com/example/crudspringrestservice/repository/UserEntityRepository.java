package com.example.crudspringrestservice.repository;

import com.example.crudspringrestservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}