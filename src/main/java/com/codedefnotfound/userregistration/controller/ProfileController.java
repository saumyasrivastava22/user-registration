package com.codedefnotfound.userregistration.controller;

import com.codedefnotfound.userregistration.exception.NotFoundException;
import com.codedefnotfound.userregistration.model.UserProfile;
import com.codedefnotfound.userregistration.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserProfile> createProfile(@RequestBody UserProfile userProfile) {
        return service.createProfile(userProfile);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<UserProfile>> deleteProfile(@PathVariable("username") String username) {
        return service.deleteProfile(username).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<UserProfile>> getProfile(@PathVariable("username") String username) throws NotFoundException {
        return service.getProfile(username).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
