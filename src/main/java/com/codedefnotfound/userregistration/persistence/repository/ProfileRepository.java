package com.codedefnotfound.userregistration.persistence.repository;

import com.codedefnotfound.userregistration.persistence.entity.Profile;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProfileRepository extends ReactiveCrudRepository<Profile, Long> {

    @Query("DELETE FROM PROFILE WHERE USERNAME = ?")
    public Mono<Profile> deleteByUsername(String username);

    @Query("SELECT * FROM PROFILE WHERE USERNAME = ?")
    public Mono<Profile> findByUsername(String username);

}
