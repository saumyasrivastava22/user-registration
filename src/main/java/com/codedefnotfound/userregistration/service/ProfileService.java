package com.codedefnotfound.userregistration.service;

import com.codedefnotfound.userregistration.model.UserProfile;
import com.codedefnotfound.userregistration.persistence.entity.Profile;
import com.codedefnotfound.userregistration.persistence.mapper.ModelMapper;
import com.codedefnotfound.userregistration.persistence.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ModelMapper mapper;

    public Mono<UserProfile> createProfile(UserProfile userProfile) {
        Profile newEntity = mapper.convertToEntity(userProfile);
        return profileRepository.save(newEntity).map(entity -> mapper.convertToDTO(entity));
        // send mail async for activation.
    }

    public Mono<UserProfile> deleteProfile(String username) {
        return profileRepository.deleteByUsername(username).map(entity -> mapper.convertToDTO(entity));
    }

    public Mono<UserProfile> getProfile(String username) {
        return profileRepository.findByUsername(username).map(entity -> mapper.convertToDTO(entity));
    }
}
