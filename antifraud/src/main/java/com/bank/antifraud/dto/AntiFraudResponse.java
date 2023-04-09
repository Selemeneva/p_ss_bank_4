package com.bank.antifraud.dto;

import lombok.Builder;

@Builder
public record AntiFraudResponse(long suspiciousTransferId, boolean isApproved, String reason) {
}
