package com.lezgo.authentication.controllers;

import com.lezgo.authentication.controllers.sharedServices.TokenCreationService;
import com.lezgo.authentication.models.AuthenticationRequest;
import com.lezgo.authentication.models.AuthenticationResponse;
import com.lezgo.authentication.models.UserInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenCreationService tokenCreationService;

    public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final String jwt = tokenCreationService.createJwtToker(authenticationRequest.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
