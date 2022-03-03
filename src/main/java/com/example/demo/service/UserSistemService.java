package com.example.demo.service;

import com.example.demo.model.UserSistemModel;
import com.example.demo.rest.UserSistemDTO;

public interface UserSistemService {
    UserSistemModel getUserSistemByUsername(String username);

    UserSistemModel addUserSistem(UserSistemDTO user);

    String encrypt(String password);
}
