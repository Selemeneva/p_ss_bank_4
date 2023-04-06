package com.bank.profile.service;

import com.bank.profile.entity.Registration;
import com.bank.profile.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration getById(Long id) {
        return registrationRepository.getReferenceById(id);
    }

    @Override
    public void delete(Registration registration) {
        registrationRepository.delete(registration);
    }

    @Override
    public void update(Registration registration) {
        registrationRepository.save(registration);
    }
}
