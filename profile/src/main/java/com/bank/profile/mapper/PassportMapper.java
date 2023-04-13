package com.bank.profile.mapper;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    @Mapping(target = "registrationId", source = "registration.id")
    PassportDto toDto(Passport passport);

    Passport toEntity(PassportDto passportDto);
}
