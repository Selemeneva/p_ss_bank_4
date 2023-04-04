package com.bank.profile.mapper;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    @Mappings({
            @Mapping(source = "passport.registration", target = "registrationDto")
    })
    PassportDto toDto(Passport passport);

    @Mappings({
            @Mapping(source = "passportDto.registrationDto", target = "registration")
    })
    Passport toEntity(PassportDto passportDto);
}
