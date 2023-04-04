package com.bank.profile.mapper;

import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PassportMapper.class, ActualRegistrationMapper.class})
public interface ProfileMapper {
    @Mappings({
            @Mapping(source = "profile.passport", target = "passportDto"),
            @Mapping(source = "profile.actualRegistration", target = "actualRegistrationDto")
    })
    ProfileDto toDto(Profile profile);
    @Mappings({
            @Mapping(source = "profileDto.passportDto", target = "passport"),
            @Mapping(source = "profileDto.actualRegistrationDto", target = "actualRegistration")
    })
    Profile toEntity(ProfileDto profileDto);
}
