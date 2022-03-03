package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.UserSistemModel;

@Repository
public interface UserSistemDb extends JpaRepository<UserSistemModel, Long> {
    UserSistemModel findByUsername(String username);
}
