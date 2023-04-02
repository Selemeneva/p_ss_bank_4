package com.bank.profile.service;

import com.bank.profile.entity.Registration;

import java.util.List;

public interface RegistrationService {
    void save(Registration registration);
    List<Registration> findAll();
    Registration getById(Long id);
    void delete(Long id);
    void update(Registration registration);
}
