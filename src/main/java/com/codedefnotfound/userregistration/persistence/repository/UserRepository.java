package com.codedefnotfound.userregistration.persistence.repository;

import com.codedefnotfound.userregistration.persistence.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
