package com.example.demo.controller;

import java.text.ParseException;

import javax.validation.Valid;

import com.example.demo.model.UserSistemModel;
import com.example.demo.rest.UserSistemDTO;
import com.example.demo.service.UserSistemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloWorldController {

    @Autowired
    private UserSistemService userSistemService;

    @GetMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    @PostMapping(value = "/usersistem/add")
    private String createRequestUpdateItem(
            @Valid @RequestBody UserSistemDTO userSistem,
            BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        } else {
            try {
                userSistemService.addUserSistem(userSistem);
            } catch (Exception e) {
                return e.toString();
            }
            return "success";
        }
    }

}
