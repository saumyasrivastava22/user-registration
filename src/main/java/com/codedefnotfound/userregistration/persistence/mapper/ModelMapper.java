package com.codedefnotfound.userregistration.persistence.mapper;

import com.codedefnotfound.userregistration.model.NewUser;
import com.codedefnotfound.userregistration.model.Profile;
import com.codedefnotfound.userregistration.model.State;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public com.codedefnotfound.userregistration.persistence.entity.Profile convertToEntity(Profile profile) {
        return com.codedefnotfound.userregistration.persistence.entity.Profile.builder()
                .username(profile.getUsername())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .email(profile.getEmail())
                .mobile(profile.getMobile())
                .state(profile.getState())
                .build();
    }

    public com.codedefnotfound.userregistration.persistence.entity.User convertToEntity(NewUser user) {
        return com.codedefnotfound.userregistration.persistence.entity.User.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .state(State.INACTIVE)
                .build();
    }

    public Profile convertToDTO(com.codedefnotfound.userregistration.persistence.entity.Profile profile) {
        return Profile.builder()
                .username(profile.getUsername())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .email(profile.getEmail())
                .mobile(profile.getMobile())
                .state(profile.getState())
                .build();
    }
}
