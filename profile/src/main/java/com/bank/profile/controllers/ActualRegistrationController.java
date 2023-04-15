package com.bank.profile.controllers;

import com.bank.profile.dto.ActualRegistrationDto;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.mapper.ActualRegistrationMapper;
import com.bank.profile.service.ActualRegistrationService;
import com.bank.profile.util.Updater;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/actual_registration/")
public class ActualRegistrationController {
    private final ActualRegistrationService actualRegistrationService;
    private final ActualRegistrationMapper actualRegistrationMapper;
    private static final Logger logger = LoggerFactory.getLogger(ActualRegistrationController.class);

    public ActualRegistrationController(ActualRegistrationService actualRegistrationService, ActualRegistrationMapper actualRegistrationMapper) {
        this.actualRegistrationService = actualRegistrationService;
        this.actualRegistrationMapper = actualRegistrationMapper;
    }

    @GetMapping("list")
    public ResponseEntity<List<ActualRegistration>> getAllActualRegistrations() {
        logger.info("Запрос списка всех актуальных регистраций");

        List<ActualRegistration> actualRegistrations = actualRegistrationService.findAll();

        return ResponseEntity.ok(actualRegistrations);
    }

    @PostMapping("create")
    public ResponseEntity<ActualRegistration> createActualRegistration(@RequestBody ActualRegistrationDto actualRegistrationDto){
        logger.info("Создание новой актуальной регистрации");

        ActualRegistration actualRegistration = actualRegistrationMapper.toEntity(actualRegistrationDto);
        actualRegistrationService.save(actualRegistration);

        return ResponseEntity.ok(actualRegistration);
    }

    @GetMapping("{id}")
    public ResponseEntity<ActualRegistration> getActualRegistrationById(@PathVariable long id) {
        logger.info("Запрос актуальной регистрации с id {}", id);

        if (!actualRegistrationService.existById(id)) {
            throw new EntityNotFoundException("Актуальной регистрации с таким id не существует");
        }
        ActualRegistration actualRegistration = actualRegistrationService.findById(id);
        return ResponseEntity.ok(actualRegistration);
    }

    @PatchMapping("update")
    public ResponseEntity<ActualRegistration> updateActualRegistrationById(@RequestBody ActualRegistrationDto actualRegistrationDto) throws JsonProcessingException {
        Long id = actualRegistrationDto.getId();

        logger.info("Запрос на редактирование актуальной регистрации с id {}", id);

        if (!actualRegistrationService.existById(id)) {
            throw new EntityNotFoundException("Регистрации с таким id не существует");
        }
        ActualRegistration unupdatedActualRegistration = actualRegistrationService.findById(id);
        ActualRegistration actualRegistration = actualRegistrationMapper.toEntity(actualRegistrationDto);

        Updater.updateInformationAboutCreating(actualRegistration, unupdatedActualRegistration);
        actualRegistrationService.update(actualRegistration);

        return ResponseEntity.ok(actualRegistration);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ActualRegistration> deleteUser(@PathVariable Long id) {
        logger.info("Запрос на удаление актуальной регистрации с id {}", id);

        if (!actualRegistrationService.existById(id)) {
            throw new EntityNotFoundException("актуальной регистрации с таким id не существует");
        }

        actualRegistrationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
