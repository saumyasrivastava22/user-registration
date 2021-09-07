package com.codedefnotfound.userregistration.service;

import com.codedefnotfound.userregistration.model.Profile;
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

    public Mono<Profile> createProfile(Profile profile) {
        com.codedefnotfound.userregistration.persistence.entity.Profile newEntity = mapper.convertToEntity(profile);
        return profileRepository.save(newEntity).map(entity -> mapper.convertToDTO(entity));
        // send mail async for activation.
    }

    public Mono<Profile> deleteProfile(String username) {
        return profileRepository.deleteByUsername(username).map(entity -> mapper.convertToDTO(entity));
    }

    public Mono<Profile> getProfile(String username) {
        return profileRepository.findByUsername(username).map(entity -> mapper.convertToDTO(entity));
    }
}
