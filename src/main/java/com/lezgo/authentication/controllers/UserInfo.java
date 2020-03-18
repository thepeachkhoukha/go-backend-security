package com.lezgo.authentication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserInfo {
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    ResponseEntity<?> userInfo(@RequestParam String username);

    @RequestMapping(value = "/usergeneralinfo", method = RequestMethod.GET)
    ResponseEntity<?> userGeneralInfo(@RequestParam String username);
}
