package com.bank.profile.service;

import com.bank.profile.dto.ActualRegistrationDto;
import com.bank.profile.dto.PassportDto;
import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Profile;
import com.bank.profile.entity.Registration;
import com.bank.profile.mapper.ActualRegistrationMapper;
import com.bank.profile.mapper.ProfileMapper;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final RegistrationService registrationService;
    private final PassportService passportService;
    private final ActualRegistrationService actualRegistrationService;
    private final RegistrationMapper registrationMapper;
    private final ActualRegistrationMapper actualRegistrationMapper;
    private final ProfileMapper profileMapper;

    public ProfileServiceImpl(ProfileRepository profileRepository, RegistrationService registrationService, PassportService passportService, ActualRegistrationService actualRegistrationService, RegistrationMapper registrationMapper, ActualRegistrationMapper actualRegistrationMapper, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.registrationService = registrationService;
        this.passportService = passportService;
        this.actualRegistrationService = actualRegistrationService;
        this.registrationMapper = registrationMapper;
        this.actualRegistrationMapper = actualRegistrationMapper;
        this.profileMapper = profileMapper;
    }

    @Override
    public void save(ProfileDto profileDto) {
        Profile profile = profileMapper.toEntity(profileDto);
        Passport passport = profile.getPassport();
        Registration registration = passport.getRegistration();
        ActualRegistration actualRegistration = profile.getActualRegistration();

        registrationService.save(registration);
        passport.setRegistration(registration);

        passportService.save(passport);
        profile.setPassport(passport);

        actualRegistrationService.save(actualRegistration);
        profile.setActualRegistration(actualRegistration);

        profileRepository.save(profile);
    }

    @Override
    public void update(ProfileDto profileDto, Long id) {
        Profile profileToUpdate = getById(id);
        Profile profileUpdated = profileMapper.toEntity(profileDto);
        profileUpdated.setId(profileToUpdate.getId());

        PassportDto passportDto = profileDto.getPassportDto();
        Passport passportToUpdate = profileToUpdate.getPassport();
        passportService.update(passportDto, passportToUpdate.getId());

        ActualRegistration actualRegistrationToUpdate = profileToUpdate.getActualRegistration();
        ActualRegistration actualRegistrationUpdated = actualRegistrationMapper.toEntity(profileDto.getActualRegistrationDto());
        actualRegistrationUpdated.setId(actualRegistrationToUpdate.getId());
        actualRegistrationService.update(actualRegistrationUpdated);

        profileRepository.save(profileUpdated);
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.getReferenceById(id);
    }
}
