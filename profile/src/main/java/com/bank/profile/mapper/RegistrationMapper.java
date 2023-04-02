package com.bank.profile.mapper;

import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.entity.Registration;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    RegistrationDto toDto(Registration registration);
    Registration toRegistration(RegistrationDto registrationDto);
}
