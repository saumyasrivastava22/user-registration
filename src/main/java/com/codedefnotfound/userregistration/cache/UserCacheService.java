package com.codedefnotfound.userregistration.cache;

import com.codedefnotfound.userregistration.model.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserCacheService {

    private RedisTemplate template;

    private static final String HASH_KEY = "USERS";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCacheService.class);

    public State addIfNotExists(final String username, final State state) {
        if(Objects.nonNull(template.opsForHash().get(HASH_KEY, username)))
            return State.RESERVED;

        template.opsForHash().put(HASH_KEY, username, state);
        return state;
    }
}
