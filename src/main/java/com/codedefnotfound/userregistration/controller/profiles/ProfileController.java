package com.codedefnotfound.userregistration.controller.profiles;

import com.codedefnotfound.userregistration.exception.UsernameAlreadyExistsException;
import com.codedefnotfound.userregistration.model.Profile;
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
    public Mono<Profile> createProfile(@RequestBody Profile profile) {
        return service.createProfile(profile);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Profile>> deleteProfile(@PathVariable("username") String username) {
        return service.deleteProfile(username).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Profile>> getProfile(@PathVariable("username") String username) throws UsernameAlreadyExistsException {
        return service.getProfile(username).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
