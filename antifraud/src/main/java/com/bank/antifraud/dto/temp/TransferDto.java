package com.bank.antifraud.dto.temp;

import lombok.Builder;

import java.time.LocalDateTime;

//Любой объект transfer-микросервиса
@Builder
public record TransferDto(long id, long number, double amount, String purpose, long detailsId, LocalDateTime dateTime) {
}
