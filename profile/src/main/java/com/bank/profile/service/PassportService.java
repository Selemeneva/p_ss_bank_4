package com.bank.profile.service;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;

import java.util.List;

public interface PassportService {
    Passport save(PassportDto passportDto);
    List<Passport> findAll();
    Passport getById(Long id);
    void delete(Passport passport);
    Passport update(PassportDto passportDto, Long id);
}
