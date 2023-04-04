package com.bank.profile.service;

import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.Profile;

import java.util.List;

public interface ProfileService {
    void save(ProfileDto profileDto);
    List<Profile> findAll();
    Profile getById(Long id);
    void update(ProfileDto profileDto, Long id);
}
