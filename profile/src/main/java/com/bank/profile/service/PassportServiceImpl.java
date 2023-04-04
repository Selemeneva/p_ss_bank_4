package com.bank.profile.service;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Registration;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;
    private final RegistrationMapper registrationMapper;
    private final PassportMapper passportMapper;
    private final RegistrationService registrationService;

    public PassportServiceImpl(PassportRepository passportRepository, RegistrationMapper registrationMapper, PassportMapper passportMapper, RegistrationService registrationService) {
        this.passportRepository = passportRepository;
        this.registrationMapper = registrationMapper;
        this.passportMapper = passportMapper;
        this.registrationService = registrationService;
    }

    @Override
    public void save(Passport passport) {
        passportRepository.save(passport);
    }

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    @Override
    public Passport findById(Long id) {
        return passportRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(PassportDto passportDto, Long id) {
        Passport passportToUpdate = findById(id);

        Registration registrationUpdated = registrationMapper.toEntity(passportDto.getRegistrationDto());
        registrationUpdated.setId(passportToUpdate.getRegistration().getId());

        Passport passportUpdated = passportMapper.toEntity(passportDto);
        passportUpdated.setRegistration(registrationUpdated);

        registrationService.update(registrationUpdated);
        passportRepository.save(passportUpdated);
    }

    @Override
    public void delete(Long id) {
        passportRepository.deleteById(id);
    }
}
