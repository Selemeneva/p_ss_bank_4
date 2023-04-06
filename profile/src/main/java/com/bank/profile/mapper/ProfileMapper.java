package com.bank.profile.mapper;

import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(source = "passport.id", target = "passportId")
    @Mapping(source = "actualRegistration.id", target = "actualRegistrationId")
    ProfileDto toDto(Profile profile);

    Profile toEntity(ProfileDto profileDto);
}
