package com.lezgo.authentication.controllers;

import com.lezgo.authentication.models.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpImplementation implements SignUp {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestBody SignUpRequest signUpRequest){
        return this.signUpService.signUp(signUpRequest);
    }
}
