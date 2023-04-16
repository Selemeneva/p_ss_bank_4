package com.bank.profile.service;

import com.bank.profile.dto.ActualRegistrationDto;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.mapper.ActualRegistrationMapper;
import com.bank.profile.repository.ActualRegistrationRepository;
import com.bank.profile.util.EntityJsonBeforeUpdateSaver;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualRegistrationImpl implements ActualRegistrationService {
    private final ActualRegistrationRepository actualRegistrationRepository;
    private final ActualRegistrationMapper actualRegistrationMapper;

    public ActualRegistrationImpl(ActualRegistrationRepository actualRegistrationRepository, ActualRegistrationMapper actualRegistrationMapper) {
        this.actualRegistrationRepository = actualRegistrationRepository;
        this.actualRegistrationMapper = actualRegistrationMapper;
    }

    @Override
    public ActualRegistration save(ActualRegistrationDto actualRegistrationDto) {
        ActualRegistration actualRegistration = actualRegistrationMapper.toEntity(actualRegistrationDto);
        actualRegistrationRepository.save(actualRegistration);
        return actualRegistration;
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
    public void update(ActualRegistration actualRegistration) throws JsonProcessingException {
        ActualRegistration unupdatedActualRegistration = findById(actualRegistration.getId());

        actualRegistration.setCreatedBy(unupdatedActualRegistration.getCreatedBy());
        actualRegistration.setCreatedAt(unupdatedActualRegistration.getCreatedAt());
        EntityJsonBeforeUpdateSaver.saveEntityJsonBeforeUpdate(unupdatedActualRegistration);

        actualRegistrationRepository.save(actualRegistration);
    }

    @Override
    public void delete(ActualRegistration actualRegistration) {
        actualRegistrationRepository.delete(actualRegistration);
    }
}
