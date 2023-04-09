package com.bank.antifraud.dto.temp;

import lombok.Builder;

import java.util.List;

//Профиль со счетами
@Builder
public record ProfileDetailsDto(long profileId, List<Long> accountIds, long transferActualAccount) {
}
