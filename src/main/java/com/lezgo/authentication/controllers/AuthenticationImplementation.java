package com.lezgo.authentication.controllers;

import com.lezgo.authentication.models.AuthenticationRequest;
import com.lezgo.authentication.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationImplementation implements Authentication {
    
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UsersRespository usersRespository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return authenticationService.createAuthenticationToken(authenticationRequest);
    }
}
