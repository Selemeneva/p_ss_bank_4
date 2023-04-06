package com.bank.profile.service;

import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Profile;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.mapper.ProfileMapper;
import com.bank.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final PassportService passportService;
    private final ActualRegistrationService actualRegistrationService;
    private final ProfileMapper profileMapper;

    public ProfileServiceImpl(ProfileRepository profileRepository, PassportService passportService, PassportMapper passportMapper, ActualRegistrationService actualRegistrationService, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.passportService = passportService;
        this.actualRegistrationService = actualRegistrationService;
        this.profileMapper = profileMapper;
    }

    @Override
    public Profile save(ProfileDto profileDto) {
        Profile profile = profileMapper.toEntity(profileDto);
        Passport passport = passportService.getById(profileDto.getPassportId());
        profile.setPassport(passport);
        ActualRegistration actualRegistration = actualRegistrationService.getById(profileDto.getActualRegistrationId());
        profile.setActualRegistration(actualRegistration);
        profileRepository.save(profile);
        return profile;
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.getReferenceById(id);
    }

    @Override
    public Profile update(ProfileDto profileDto, Long id) {
        Profile profile = profileMapper.toEntity(profileDto);
        profile.setId(id);
        Passport passport = passportService.getById(profileDto.getPassportId());
        profile.setPassport(passport);
        ActualRegistration actualRegistration = actualRegistrationService.getById(profileDto.getActualRegistrationId());
        profile.setActualRegistration(actualRegistration);
        profileRepository.save(profile);
        return profile;
    }

    @Override
    public void delete(Profile profile) {
        profileRepository.delete(profile);
    }
}
