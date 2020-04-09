package com.lezgo.authentication.controllers;

import com.lezgo.authentication.controllers.sharedServices.TokenCreationService;
import com.lezgo.authentication.entities.User;
import com.lezgo.authentication.entities.UserDetails;
import com.lezgo.authentication.models.AuthenticationResponse;
import com.lezgo.authentication.models.SignUpRequest;
import com.lezgo.authentication.repository.UserDetailsRepository;
import com.lezgo.authentication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {

    @Autowired
    private TokenCreationService tokenCreationService;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public ResponseEntity signUp(SignUpRequest signUpRequest) {
        if (userExists(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("user exists");
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            User user = User.builder()
                    .username(signUpRequest.getUsername())
                    .password(bCryptPasswordEncoder.encode(signUpRequest.getPassword()))
                    .build();
            usersRepository.save(user);

            UserDetails userDetails = UserDetails.builder()
                    .username(signUpRequest.getUsername())
                    .name(signUpRequest.getName())
                    .location(signUpRequest.getLocation())
                    .occupation(signUpRequest.getOccupation())
                    .university(signUpRequest.getUniversity())
                    .lat(signUpRequest.getLat())
                    .lng(signUpRequest.getLng())
                    .image(signUpRequest.getImage())
                    .build();
            userDetailsRepository.save(userDetails);
            String jwt = tokenCreationService.createJwtToker(userDetails.getUsername());
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }
    }

    private boolean userExists(String username) {
        System.out.println(usersRepository.findByUsername(username));
        return usersRepository.findByUsername(username) != null;
    }
}