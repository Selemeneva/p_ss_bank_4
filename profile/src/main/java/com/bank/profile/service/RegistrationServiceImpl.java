package com.bank.profile.service;

import com.bank.profile.entity.Registration;
import com.bank.profile.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    private final RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public void save(Registration registration) {
        registrationRepository.save(registration);
    }
}
