package com.bank.profile.service;

import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.repository.ActualRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualRegistrationImpl implements ActualRegistrationService {
    private final ActualRegistrationRepository actualRegistrationRepository;

    public ActualRegistrationImpl(ActualRegistrationRepository actualRegistrationRepository) {
        this.actualRegistrationRepository = actualRegistrationRepository;
    }

    @Override
    public void save(ActualRegistration actualRegistration) {
        actualRegistrationRepository.save(actualRegistration);
    }

    @Override
    public List<ActualRegistration> findAll() {
        return actualRegistrationRepository.findAll();
    }

    @Override
    public ActualRegistration getById(Long id) {
        return actualRegistrationRepository.getReferenceById(id);
    }

    @Override
    public void update(ActualRegistration actualRegistration) {
        actualRegistrationRepository.save(actualRegistration);
    }
}
