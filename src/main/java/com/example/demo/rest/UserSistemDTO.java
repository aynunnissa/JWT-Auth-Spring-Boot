package com.example.demo.rest;

import com.example.demo.model.UserSistemModel;

public class UserSistemDTO {
    public Long idPegawai;
    public String nama;
    public String username;
    public String password;

    public UserSistemModel convertToUserSistemModel() {
        UserSistemModel request = new UserSistemModel();
        request.setIdPegawai(idPegawai);
        request.setNama(nama);
        request.setUsername(username);
        request.setPassword(password);
        return request;
    }

    public UserSistemModel convertToUserSistemModel(UserSistemModel request) {
        request.setIdPegawai(idPegawai);
        request.setNama(nama);
        request.setUsername(username);
        request.setPassword(password);
        return request;
    }
}
