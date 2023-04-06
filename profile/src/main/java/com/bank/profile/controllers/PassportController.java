package com.bank.profile.controllers;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.service.PassportService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "Операции с паспортами")
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
    public ResponseEntity<Passport> getPassportById(@PathVariable long id) {
        Passport passport = passportService.getById(id);
        return ResponseEntity.ok(passport);
    }

    @PostMapping("create")
    public ResponseEntity<Passport> createPassport(@RequestBody PassportDto passportDto) {
        Passport passport = passportService.save(passportDto);
        return new ResponseEntity<>(passport, HttpStatus.CREATED);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Passport> updatePassport(@RequestBody PassportDto passportDto, @PathVariable Long id) {
        Passport passport = passportService.update(passportDto, id);
        return ResponseEntity.ok(passport);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Passport> deleteUser(@PathVariable Long id) {
        Passport passport = passportService.getById(id);
        passportService.delete(passport);
        return ResponseEntity.ok().build();
    }
}
