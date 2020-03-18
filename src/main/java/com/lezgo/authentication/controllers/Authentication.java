package com.lezgo.authentication.controllers;

import com.lezgo.authentication.models.AuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface Authentication {
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception;
}
