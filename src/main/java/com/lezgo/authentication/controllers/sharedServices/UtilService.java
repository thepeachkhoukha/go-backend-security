package com.lezgo.authentication.controllers.sharedServices;


import com.lezgo.authentication.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;


public class UtilService {
    @Autowired
    private UsersRespository usersRespository;

    public boolean userExists(String username){
        System.out.println(usersRespository.findByUsername(username));
        return usersRespository.findByUsername(username) != null;
    }
}
