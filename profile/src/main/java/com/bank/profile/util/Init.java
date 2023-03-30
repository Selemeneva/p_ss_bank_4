package com.bank.profile.util;

import com.bank.profile.entity.Registration;
import com.bank.profile.service.RegistrationService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Init {
    private final RegistrationService registrationService;

    public Init(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostConstruct
    public void initialization() {
        Registration registration = new Registration();
        registration.setCountry("Russia");
        registration.setRegion("Europa");
        registration.setCity("Moscow");
        registration.setDistrict("Ololo");
        registration.setLocality("Ololo");
        registration.setStreet("Street");
        registration.setHouseNumber("123");
        registration.setHouseBlock("5");
        registration.setFlatNumber("123");
        registration.setIndex(12345L);
        registration.setColumns(12);

        registrationService.save(registration);
    }
}
