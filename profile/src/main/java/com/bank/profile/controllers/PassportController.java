package com.bank.profile.controllers;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.service.PassportService;
import com.bank.profile.service.RegistrationService;
import com.bank.profile.util.Updater;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/passport/")
public class PassportController {

    private final PassportService passportService;
    private final PassportMapper passportMapper;
    private final RegistrationService registrationService;
    private final RegistrationMapper registrationMapper;
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    public PassportController(PassportService passportService, PassportMapper passportMapper, RegistrationMapper registrationMapper, RegistrationService registrationService, RegistrationMapper registrationMapper1) {
        this.passportService = passportService;
        this.passportMapper = passportMapper;
        this.registrationService = registrationService;
        this.registrationMapper = registrationMapper1;
    }

    @GetMapping("list")
    public ResponseEntity<List<Passport>> getAllPassports() {
        logger.info("Запрос списка всех паспортов");
        List<Passport> passports = passportService.findAll();

        return ResponseEntity.ok(passports);
    }

    @GetMapping("{id}")
    public ResponseEntity<Passport> getPassportById(@PathVariable long id) {
        logger.info("Запрос паспорта с id {}", id);

        if (!passportService.existById(id)) {
            throw new EntityNotFoundException("Паспорта с таким id не существует");
        }

        Passport passport = passportService.findById(id);

        return ResponseEntity.ok(passport);
    }

    @PostMapping("create")
    public ResponseEntity<Passport> createPassport(@RequestBody PassportDto passportDto) {
        logger.info("Запрос на создание паспорта");

        Passport passport = passportMapper.toEntity(passportDto);
        Long registrationId = passportDto.getRegistrationId();

        if (!registrationService.existById(registrationId)) {
            throw new EntityNotFoundException("Вы пытаетесь создать паспорт с не существующей регистрацией");
        }

        passport.setRegistration(registrationService.findById(registrationId));
        passportService.save(passport);

        return ResponseEntity.ok(passport);
    }

    @PatchMapping("update")
    public ResponseEntity<Passport> updatePassport(@RequestBody PassportDto passportDto) throws JsonProcessingException {
        Long id = passportDto.getId();
        Long registrationId = passportDto.getRegistrationId();

        logger.info("Запрос на обновление паспорта с id {}", id);

        if (!passportService.existById(id)) {
            throw new EntityNotFoundException("Паспорта с таким id не существует");
        }

        if (!registrationService.existById(registrationId)) {
            throw new EntityNotFoundException("Вы пытаетесь создать паспорт с не существующей регистрацией");
        }

        Passport unupdatedPassport = passportService.findById(id);
        Passport passport = passportMapper.toEntity(passportDto);
        passport.setRegistration(registrationService.findById(registrationId));

        Updater.updateInformationAboutCreating(passport, unupdatedPassport);
        passportService.update(passport);

        return ResponseEntity.ok(passport);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Passport> deleteUser(@PathVariable Long id) {
        logger.info("Запрос на удаление паспорта с id {}", id);

        if (!passportService.existById(id)) {
            throw new EntityNotFoundException("Паспорта с таким id не существует");
        }

        passportService.delete(id);
        return ResponseEntity.ok().build();
    }
}
