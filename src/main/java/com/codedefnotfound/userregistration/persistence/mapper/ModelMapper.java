package com.codedefnotfound.userregistration.persistence.mapper;

import com.codedefnotfound.userregistration.model.UserProfile;
import com.codedefnotfound.userregistration.persistence.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public Profile convertToEntity(UserProfile userProfile) {
        return Profile.builder()
                .username(userProfile.getUsername())
                .firstName(userProfile.getFirstName())
                .lastName(userProfile.getLastName())
                .email(userProfile.getEmail())
                .mobile(userProfile.getMobile())
                .state(userProfile.getState())
                .build();
    }

    public UserProfile convertToDTO(Profile profile) {
        return UserProfile.builder()
                .username(profile.getUsername())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .email(profile.getEmail())
                .mobile(profile.getMobile())
                .state(profile.getState())
                .build();
    }
}
