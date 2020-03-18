package com.lezgo.authentication.controllers.sharedServices;

import com.lezgo.authentication.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class TokenCreationService {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    public String createJwtToker(String userName){
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userName);

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return jwt;
    }
}
