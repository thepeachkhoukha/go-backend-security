package com.lezgo.authentication.controllers;

import com.lezgo.authentication.models.FriendshipRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

public interface UserInfo {
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    ResponseEntity<?> userInfo(@RequestParam String username);

    @RequestMapping(value = "/usergeneralinfo", method = RequestMethod.GET)
    ResponseEntity<?> getUserGeneralInfo(@RequestParam String username);

    @RequestMapping(value = "/usercircle", method = RequestMethod.GET)
    ResponseEntity<?> getUserCircle(@RequestParam @NotNull String username);

    @RequestMapping(value = "/friend", method = RequestMethod.POST)
    ResponseEntity<?> checkFriendship(@RequestParam("username") String username, @RequestParam("friendname") String friendname);

    @RequestMapping(value = "/addfriend", method = RequestMethod.POST)
    ResponseEntity<?> addFriendship(@RequestBody FriendshipRequest friendshipRequest);

    @RequestMapping(value = "/deletefriend", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteFriendship(@RequestParam("username") String username, @RequestParam("friendname") String friendname);
}
