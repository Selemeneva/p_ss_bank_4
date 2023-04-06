package com.bank.profile.mapper;

import com.bank.profile.dto.AccountDetailsIdDto;
import com.bank.profile.entity.AccountDetailsId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {

    @Mapping(source = "owner.id", target = "profileId")
    AccountDetailsIdDto toDto(AccountDetailsId accountDetailsId);
    AccountDetailsId toEntity(AccountDetailsIdDto accountDetailsIdDto);
}
