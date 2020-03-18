package com.lezgo.authentication.controllers;

import com.lezgo.authentication.entities.UserDetails;
import com.lezgo.authentication.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails userInfo(String username){
        UserDetails userDetails = userDetailsRepository.findByUsername(username);
        return userDetails;
    }
}
