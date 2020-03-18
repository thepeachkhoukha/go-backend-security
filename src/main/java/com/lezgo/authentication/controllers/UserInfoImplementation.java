package com.lezgo.authentication.controllers;

import com.lezgo.authentication.entities.UserDetails;
import com.lezgo.authentication.models.UserGeneralInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInfoImplementation implements UserInfo {

    @Autowired
    private UserInfoService userInfo;

    @Override
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public ResponseEntity<?> userInfo(@RequestParam String username) {

        return ResponseEntity.ok().body(userInfo.userInfo(username));
    }

    @RequestMapping(value = "/usergeneralinfo", method = RequestMethod.GET)

    public ResponseEntity<?> userGeneralInfo(@RequestParam String username){
        UserDetails userDetails = this.userInfo.userInfo(username);
        return ResponseEntity.ok().body(UserGeneralInfo.builder()
                        .city(userDetails.getLocation())
                        .lat(userDetails.getLat())
                        .lng(userDetails.getLng())
                        .image(userDetails.getImage())
                        .build());
    }
}
