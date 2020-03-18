package com.lezgo.authentication.services;

import com.lezgo.authentication.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRespository usersRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.lezgo.authentication.entities.User user = usersRespository.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}