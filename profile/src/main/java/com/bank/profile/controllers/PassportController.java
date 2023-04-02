package com.bank.profile.controllers;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Registration;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.service.PassportService;
import com.bank.profile.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passport/")
public class PassportController {

    private final PassportService passportService;
    private final PassportMapper passportMapper;
    private final RegistrationService registrationService;

    public PassportController(PassportService passportService, PassportMapper passportMapper, RegistrationMapper registrationMapper, RegistrationService registrationService) {
        this.passportService = passportService;
        this.passportMapper = passportMapper;
        this.registrationService = registrationService;
    }

    @GetMapping("list")
    public ResponseEntity<List<Passport>> getAllPassports() {
        List<Passport> passports = passportService.findAll();
        return ResponseEntity.ok(passports);
    }

    @GetMapping("{id}")
    public ResponseEntity<PassportDto> getPassportById(@PathVariable long id) {
        Passport passport = passportService.findById(id);
        PassportDto passportDto = passportMapper.toDto(passport);
        return ResponseEntity.ok(passportDto);
    }

    @PostMapping("create")
    public ResponseEntity<Passport> createPassport(@RequestBody PassportDto passportDto) {
        Passport passport = passportMapper.toPassport(passportDto);
        Registration registration = passportDto.getRegistration();
        registration.setId(null);
        registrationService.save(registration);
        passportService.save(passport);
        return new ResponseEntity<>(passport, HttpStatus.CREATED);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Passport> updatePassport(@RequestBody PassportDto passportDto, @PathVariable Long id) {
        Passport passport = passportMapper.toPassport(passportDto);
        passport.setId(id);
        passportService.update(passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Passport> deleteUser(@PathVariable Long id) {
        registrationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
