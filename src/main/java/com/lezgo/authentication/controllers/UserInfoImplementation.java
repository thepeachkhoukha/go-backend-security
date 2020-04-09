package com.lezgo.authentication.controllers;

import com.lezgo.authentication.entities.UserDetails;
import com.lezgo.authentication.models.FriendshipRequest;
import com.lezgo.authentication.models.UserGeneralInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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
    public ResponseEntity<?> getUserGeneralInfo(@RequestParam String username){
        UserDetails userDetails = userInfo.userInfo(username);
        return ResponseEntity.ok().body(UserGeneralInfo.builder()
                        .city(userDetails.getLocation())
                        .lat(userDetails.getLat())
                        .lng(userDetails.getLng())
                        .image(userDetails.getImage())
                        .build());
    }

    @RequestMapping(value = "/usercircle", method = RequestMethod.GET)
    public ResponseEntity<?> getUserCircle(@RequestParam @NotNull String username){
        return ResponseEntity.ok().body(userInfo.getUserCircle(username));
    }

    @RequestMapping(value = "/friend", method = RequestMethod.GET)
    public ResponseEntity<?> checkFriendship(@RequestParam("username") String username, @RequestParam("friendname") String friendname){
        return ResponseEntity.ok().body(userInfo.checkFriendship(username, friendname));
    }

    @RequestMapping(value = "/addfriend", method = RequestMethod.POST)
    public ResponseEntity<?> addFriendship(@RequestBody FriendshipRequest friendshipRequest){
        if(userInfo.addFriendship(friendshipRequest)){
            return ResponseEntity.ok().body("friendship has been added");
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("friendship has not been added");
    }

    @RequestMapping(value = "/deletefriend", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFriendship(@RequestParam("username") String username, @RequestParam("friendname") String friendname){
        if(userInfo.deleteFriendship(username, friendname)){
            return ResponseEntity.ok().body("friendship has been deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("friendship has not been deleted");
        }
    }
}
