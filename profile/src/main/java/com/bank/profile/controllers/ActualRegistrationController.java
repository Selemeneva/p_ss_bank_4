package com.bank.profile.controllers;

import com.bank.profile.mapper.ActualRegistrationMapper;
import com.bank.profile.service.ActualRegistrationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actual_registration/")
public class ActualRegistrationController {
    private final ActualRegistrationService actualRegistrationService;
    private final ActualRegistrationMapper actualRegistrationMapper;
    public ActualRegistrationController(ActualRegistrationService actualRegistrationService, ActualRegistrationMapper actualRegistrationMapper) {
        this.actualRegistrationService = actualRegistrationService;
        this.actualRegistrationMapper = actualRegistrationMapper;
    }
}
