package com.bank.profile.service;

import com.bank.profile.entity.ActualRegistration;

import java.util.List;

public interface ActualRegistrationService {
    void save(ActualRegistration actualRegistration);
    List<ActualRegistration> findAll();
    ActualRegistration getById(Long id);
    void update(ActualRegistration actualRegistration);
}
