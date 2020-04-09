package com.lezgo.authentication.controllers.sharedServices;


import com.lezgo.authentication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class UtilService {
    @Autowired
    private UsersRepository usersRepository;

    public boolean userExists(String username){
        return usersRepository.findByUsername(username) != null;
    }
}
