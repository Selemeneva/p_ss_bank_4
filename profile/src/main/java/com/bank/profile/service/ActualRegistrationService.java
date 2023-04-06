package com.bank.profile.service;

import com.bank.profile.dto.ActualRegistrationDto;
import com.bank.profile.entity.ActualRegistration;

import java.util.List;

public interface ActualRegistrationService {
    ActualRegistration save(ActualRegistrationDto actualRegistrationDto);
    List<ActualRegistration> findAll();
    ActualRegistration getById(Long id);
    void update(ActualRegistration actualRegistration);
    void delete(ActualRegistration actualRegistration);
}
