package com.bank.profile.controllers;

import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.entity.Registration;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration/")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final RegistrationMapper registrationMapper;

    @Autowired
    public RegistrationController(RegistrationService registrationService, RegistrationMapper registrationMapper) {
        this.registrationService = registrationService;
        this.registrationMapper = registrationMapper;
    }

    @GetMapping("list")
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.findAll();
        return ResponseEntity.ok(registrations);
    }

    @GetMapping("{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable long id){
        Registration registration =  registrationService.getById(id);
        return ResponseEntity.ok(registration);
    }

    @PostMapping("create")
    public ResponseEntity<Registration> createRegistration(@RequestBody RegistrationDto registrationDto){
        Registration registration = registrationMapper.toRegistration(registrationDto);
        registrationService.save(registration);
        return new ResponseEntity<>(registration, HttpStatus.CREATED);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Registration> updateRegistration(@RequestBody RegistrationDto registrationDto, @PathVariable("id") long id){
        Registration registration = registrationMapper.toRegistration(registrationDto);
        registration.setId(id);
        registrationService.update(registration);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Registration> deleteUser(@PathVariable Long id) {
        registrationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
