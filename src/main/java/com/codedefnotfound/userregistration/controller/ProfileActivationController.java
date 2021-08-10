package com.codedefnotfound.userregistration.controller;

import com.codedefnotfound.userregistration.service.ActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles/{username}/activation")
public class ProfileActivationController {

    @Autowired
    private ActivationService service;

    @PutMapping
    public void activateProfile(@RequestParam("username") String username) {

    }
}
