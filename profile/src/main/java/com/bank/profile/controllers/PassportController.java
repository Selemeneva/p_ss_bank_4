package com.bank.profile.controllers;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Registration;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.service.PassportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passport/")
public class PassportController {

    private final PassportService passportService;
    private final PassportMapper passportMapper;

    public PassportController(PassportService passportService, PassportMapper passportMapper) {
        this.passportService = passportService;
        this.passportMapper = passportMapper;
    }

    @GetMapping("list")
    public ResponseEntity<List<Passport>> getAllPassports() {
        List<Passport> passports = passportService.findAll();
        return ResponseEntity.ok(passports);
    }

    @GetMapping("{id}")
    public ResponseEntity<Passport> getPassportById(@PathVariable long id){
        Passport passport =  passportService.findById(id);
        return ResponseEntity.ok(passport);
    }

    @PostMapping("create")
    public ResponseEntity<Passport> createPassport(@RequestBody PassportDto PassportDto){
        Passport passport = passportMapper.toPassport(PassportDto);
        passportService.save(passport);
        return new ResponseEntity<>(passport, HttpStatus.CREATED);
    }
}
