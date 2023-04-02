package com.bank.profile.service;

import com.bank.profile.entity.Passport;
import com.bank.profile.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public void save(Passport passport) { passportRepository.save(passport); }

    @Override
    public List<Passport> findAll() { return passportRepository.findAll(); }

    @Override
    public Passport findById(Long id) { return passportRepository.findById(id).orElseThrow(); }
}
