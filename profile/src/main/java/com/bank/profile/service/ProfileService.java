package com.bank.profile.service;

import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.Profile;

import java.util.List;

public interface ProfileService {
    Profile save(ProfileDto profileDto);
    List<Profile> findAll();
    Profile getById(Long id);
    Profile update(ProfileDto profileDto, Long id);
    void delete(Profile profile);
}
