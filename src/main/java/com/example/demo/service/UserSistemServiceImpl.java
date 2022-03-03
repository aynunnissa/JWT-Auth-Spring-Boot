package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserSistemDb;
import com.example.demo.rest.UserSistemDTO;
import com.example.demo.model.UserSistemModel;

@Service
@Transactional
public class UserSistemServiceImpl implements UserSistemService {
    @Autowired
    private UserSistemDb userSistemDb;

    @Override
    public UserSistemModel getUserSistemByUsername(String username) {
        UserSistemModel user = userSistemDb.findByUsername(username);
        System.out.println("USERNYA:" + user.getUsername());
        return user;
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordHash = passwordEncoder.encode(password);
        return passwordHash;
    }

    @Override
    public UserSistemModel addUserSistem(UserSistemDTO user) {
        UserSistemModel newUser = user.convertToUserSistemModel();
        // String pass = encrypt(user.getPassword());
        // user.setPassword(pass);
        String pass = encrypt(newUser.getPassword());
        newUser.setPassword(pass);
        newUser.setRole(null);
        return userSistemDb.save(newUser);
    }
}
