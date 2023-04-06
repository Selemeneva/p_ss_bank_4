package com.bank.profile.mapper;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    @Mapping(source = "registration.id", target = "registrationId")
    PassportDto toDto(Passport passport);

    Passport toEntity(PassportDto passportDto);

}
