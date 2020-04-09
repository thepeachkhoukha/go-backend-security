package com.lezgo.authentication.controllers;

import com.lezgo.authentication.models.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public interface SignUp {
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    ResponseEntity signUp(@RequestBody @Valid SignUpRequest signUpRequest);
}
