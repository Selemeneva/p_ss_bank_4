package com.bank.profile.controllers;

import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.entity.Registration;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.service.RegistrationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/registration/")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final RegistrationMapper registrationMapper;
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(RegistrationService registrationService, RegistrationMapper registrationMapper) {
        this.registrationService = registrationService;
        this.registrationMapper = registrationMapper;
    }

    @GetMapping("list")
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        logger.info("Запрос списка всех регистраций");

        List<Registration> registrations = registrationService.findAll();

        return ResponseEntity.ok(registrations);
    }

    @GetMapping("{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable long id){
        logger.info("Запрос регистрации с id {}", id);

        if (!registrationService.existById(id)) {
            throw new EntityNotFoundException("Регистрации с таким id не существует");
        }

        Registration registration =  registrationService.getById(id);
        return ResponseEntity.ok(registration);
    }

    @PostMapping("create")
    public ResponseEntity<Registration> createRegistration(@RequestBody RegistrationDto registrationDto){
        logger.info("Создание новой регистрации");

        Registration registration = registrationMapper.toEntity(registrationDto);
        registrationService.save(registration);

        return ResponseEntity.ok(registration);
    }

    @PatchMapping("update")
    public ResponseEntity<Registration> updateRegistration(@RequestBody RegistrationDto registrationDto){
        Long id = registrationDto.getId();

        logger.info("Запрос на редактирование регистрации с id {}", id);
        Registration registration = registrationMapper.toEntity(registrationDto);

        if (!registrationService.existById(id)) {
            throw new EntityNotFoundException("Регистрации с таким id не существует");
        }

        registrationService.update(registration);
        return ResponseEntity.ok(registration);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Registration> deleteUser(@PathVariable Long id) {
        logger.info("Запрос на удаление регистрации с id {}", id);

        if (!registrationService.existById(id)) {
            throw new EntityNotFoundException("Регистрации с таким id не существует");
        }

        registrationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
