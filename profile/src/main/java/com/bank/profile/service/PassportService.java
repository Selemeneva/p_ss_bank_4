package com.bank.profile.service;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;

import java.util.List;

public interface PassportService {
    void save(Passport passport);
    List<Passport> findAll();
    Passport findById(Long id);
    void delete(Long id);
    void update(Passport passport);
    boolean existById(Long id);
}
