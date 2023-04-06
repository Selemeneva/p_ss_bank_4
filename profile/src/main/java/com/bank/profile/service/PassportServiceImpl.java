package com.bank.profile.service;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Registration;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;
    private final RegistrationService registrationService;
    private final PassportMapper passportMapper;

    public PassportServiceImpl(PassportRepository passportRepository, RegistrationService registrationService, PassportMapper passportMapper) {
        this.passportRepository = passportRepository;
        this.registrationService = registrationService;
        this.passportMapper = passportMapper;
    }

    @Override
    public Passport save(PassportDto passportDto) {
        Passport passport = passportMapper.toEntity(passportDto);
        Registration registration = registrationService.getById(passportDto.getRegistrationId());
        passport.setRegistration(registration);
        passportRepository.save(passport);
        return passport;
    }

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    @Override
    public Passport getById(Long id) {
        return passportRepository.getReferenceById(id);
    }

    @Override
    public void delete(Passport passport) {
        passportRepository.delete(passport);
    }

    @Override
    public Passport update(PassportDto passportDto, Long id) {
        Passport passport = passportMapper.toEntity(passportDto);
        passport.setId(id);
        Registration registration = registrationService.getById(passportDto.getRegistrationId());
        passport.setRegistration(registration);
        passportRepository.save(passport);
        return passport;
    }
}
