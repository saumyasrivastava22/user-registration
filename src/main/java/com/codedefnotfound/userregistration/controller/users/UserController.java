package com.codedefnotfound.userregistration.controller.users;

import com.codedefnotfound.userregistration.model.AuthToken;
import com.codedefnotfound.userregistration.model.LoginUser;
import com.codedefnotfound.userregistration.model.NewUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody NewUser newUser) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AuthToken signIn(@RequestBody LoginUser loginUser) {

    }
}
