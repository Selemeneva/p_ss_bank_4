package com.bank.account.Mapper;

import com.bank.account.Entity.AccountDetails;
import com.bank.account.Entity.Dto.AccountDetailsDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Модуль для конвертирования сущностей AccountDetails и AccountDetailsDto
 * с помощью ModelMapper.
 */
@Component
@AllArgsConstructor
public class AccountDetailsMapper {
    private final ModelMapper modelMapper;

    /**
     * Конвертирует сущность AccountDetails в DTO AccountDetailsDto.
     * @param accountDetails объект сущности AccountDetails
     * @return DTO AccountDetailsDto
     */
    public AccountDetailsDto convertToDto(AccountDetails accountDetails) {
        return modelMapper.map(accountDetails,AccountDetailsDto.class);
    }

    /**
     * Конвертирует DTO AccountDetailsDto в сущность AccountDetails.
     * @param accountDetailsDto объект DTO AccountDetailsDto
     * @return сущность AccountDetails
     */
    public AccountDetails convertToEntity(AccountDetailsDto accountDetailsDto) {
        return modelMapper.map(accountDetailsDto, AccountDetails.class);
    }
    ObjectMapper objectMapper = new ObjectMapper();
   public String entityConvertToJson(AccountDetails accountDetails) throws JsonProcessingException {
        return objectMapper.writeValueAsString(accountDetails);
    }
}
