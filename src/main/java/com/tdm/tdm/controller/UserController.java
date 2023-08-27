package com.tdm.tdm.controller;

import com.tdm.tdm.model.UserInfo;
import com.tdm.tdm.repository.UserinfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserinfoRepo userinfoRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ResponseEntity<UserInfo> userAdd(@RequestBody UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserInfo save = userinfoRepo.save(userInfo);
        return new ResponseEntity<>(save, HttpStatus.ACCEPTED);
    }
}
