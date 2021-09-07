package com.codedefnotfound.userregistration.service;

import com.codedefnotfound.userregistration.cache.UserCacheService;
import com.codedefnotfound.userregistration.exception.UsernameAlreadyExistsException;
import com.codedefnotfound.userregistration.model.NewUser;
import com.codedefnotfound.userregistration.model.State;
import com.codedefnotfound.userregistration.persistence.entity.User;
import com.codedefnotfound.userregistration.persistence.mapper.ModelMapper;
import com.codedefnotfound.userregistration.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserCacheService cacheService;
    @Autowired
    private ActivationService activationService;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    public void createUser(NewUser newUser) throws UsernameAlreadyExistsException {
        /* add username if not exists */
        State state = cacheService.addIfNotExists(newUser.getUsername(), State.INACTIVE);
        if(state == State.RESERVED) {
            throw new UsernameAlreadyExistsException(newUser.getUsername());
        }

        /* save to database */
        User entity = mapper.convertToEntity(newUser);
        repository.save(entity);

        if(newUser.isActivateUsingOtp()) {
            /* send message */
        }
        else {
            activationService.sendMail(newUser);
        }
    }
}
