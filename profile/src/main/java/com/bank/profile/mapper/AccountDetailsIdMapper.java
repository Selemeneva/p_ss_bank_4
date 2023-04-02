package com.bank.profile.mapper;

import com.bank.profile.dto.AccountDetailsIdDto;
import com.bank.profile.entity.AccountDetailsId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {
    AccountDetailsIdDto toDto(AccountDetailsId accountDetailsId);
}
