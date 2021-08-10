package com.codedefnotfound.userregistration.controller;

import com.codedefnotfound.userregistration.model.Password;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles/{profileId}/forgot-password")
public class ForgotPasswordController {

    @PostMapping
    public void updatePassword(@RequestBody Password password) {

    }
}
