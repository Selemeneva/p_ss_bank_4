package com.bank.profile.controllers;

import com.bank.profile.dto.ActualRegistrationDto;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.mapper.ActualRegistrationMapper;
import com.bank.profile.service.ActualRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actual_registration/")
public class ActualRegistrationController {
    private final ActualRegistrationService actualRegistrationService;
    private final ActualRegistrationMapper actualRegistrationMapper;

    public ActualRegistrationController(ActualRegistrationService actualRegistrationService, ActualRegistrationMapper actualRegistrationMapper) {
        this.actualRegistrationService = actualRegistrationService;
        this.actualRegistrationMapper = actualRegistrationMapper;
    }

    @GetMapping("list")
    public ResponseEntity<List<ActualRegistration>> getAllActualRegistrations() {
        List<ActualRegistration> actualRegistrations = actualRegistrationService.findAll();
        return ResponseEntity.ok(actualRegistrations);
    }

    @GetMapping("{id}")
    public ResponseEntity<ActualRegistration> getActualRegistrationById(@PathVariable long id) {
        ActualRegistration actualRegistration = actualRegistrationService.getById(id);
        return ResponseEntity.ok(actualRegistration);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<ActualRegistration> updateActualRegistrationById(@RequestBody ActualRegistrationDto actualRegistrationDto, @PathVariable Long id) {
        ActualRegistration actualRegistration = actualRegistrationMapper.toEntity(actualRegistrationDto);
        actualRegistration.setId(id);
        actualRegistrationService.update(actualRegistration);
        return ResponseEntity.ok().build();
    }
}
