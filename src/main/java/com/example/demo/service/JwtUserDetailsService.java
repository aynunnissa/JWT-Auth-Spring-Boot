package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserSistemDb;
import com.example.demo.service.UserSistemService;
import com.example.demo.model.UserSistemModel;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserSistemDb userSistemDb;

    @Autowired
    private UserSistemService userSistemService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSistemModel user = userSistemService.getUserSistemByUsername(username);
        // System.out.println("INI USER:" + user.getUsername());
        if (user != null) {
            // System.out.println("MASUK");
            Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            // System.out.println("GA");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // if ("javainuse".equals(username)) {
        // return new User("javainuse",
        // "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
        // new ArrayList<>());
        // } else {
        // throw new UsernameNotFoundException("User not found with username: " +
        // username);
        // }
    }
}
